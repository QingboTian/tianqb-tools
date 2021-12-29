package cn.tianqb.context;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.ext.ExtensionPoint;
import cn.tianqb.pipe.Pipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Configuration
public class PipelineHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static HashMap<String, List<ExtensionPoint>> context = new HashMap<>(16);

    public static void run(String key) throws Exception {
        Pipeline pipeline = applicationContext.getBean(key, Pipeline.class);
        List<Class<ExtensionPoint>> list = pipeline.getHandler();
        for (Class<ExtensionPoint> clazz : list) {
            // 遍历执行handler

            // 此处从上下文获取扩展类key

            ExtensionPoint handler = ExtensionHolder.getBean(clazz, "");
            if (handler == null) {
                // 获取默认扩展
                ExtensionPoint extensionPoint = clazz.newInstance();
                Method method = clazz.getMethod("getDefault");
                if (method == null) {
                    throw new RuntimeException("当前管道节点存在空实现");
                }
                ExtensionPoint defaultExt = (ExtensionPoint) method.invoke(extensionPoint);
            }
        }
        List<ExtensionPoint> handler = context.get(key);
        // 遍历去执行任务
        if (!ObjectUtils.isEmpty(handler)) {
            handler.forEach(ExtensionPoint::handler);
        }
    }

    public static void set(String key, List<ExtensionPoint> exts) {
        if (ObjectUtils.isEmpty(key)) {
            return;
        }
        if (ObjectUtils.isEmpty(exts)) {
            return;
        }
        List<ExtensionPoint> old;
        if ((old = context.putIfAbsent(key, exts)) != null) {
            // 已经添加过对应的key
            log.info("pipe key is exist, key = {}, old value = {}, new value = {}", key, old, exts);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PipelineHelper.applicationContext = applicationContext;
    }
}
