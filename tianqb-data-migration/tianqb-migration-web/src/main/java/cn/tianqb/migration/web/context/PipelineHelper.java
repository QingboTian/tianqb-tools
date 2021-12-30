package cn.tianqb.migration.web.context;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.extension.ExtensionPoint;
import cn.tianqb.extension.Pipeline;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Slf4j
@Configuration
public class PipelineHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     *
     */
    private static HashMap<String, HashMap<String, List<ExtensionPoint>>> context = new HashMap<>(16);

    public static void run(String key) {
        // 获取业务身份上下文
        String biz = "mysql";

        // 获取指定业务类型的管道列表
        HashMap<String, List<ExtensionPoint>> map = context.getOrDefault(biz, Maps.newHashMap());
        List<ExtensionPoint> pipe;
        if (!ObjectUtils.isEmpty(map) && !ObjectUtils.isEmpty((pipe = map.get(key)))) {
            // 执行管道
            start(pipe);
            return;
        }

        // 获取指定业务类型的管道列表
        Pipeline pipeline = applicationContext.getBean(key, Pipeline.class);
        List<Class<ExtensionPoint>> list = pipeline.getHandler();
        List<ExtensionPoint> exts = new ArrayList<>();
        for (Class<ExtensionPoint> clazz : list) {
            // 此处从上下文获取扩展类key
            ExtensionPoint handler = ExtensionHolder.getBean(clazz, biz);
            if (handler == null) {
                // 获取默认扩展点
                handler = getDefault(clazz);
            }
            exts.add(handler);
        }
        // 追加指定业务类型的管道
        map.put(key, exts);
        // set context
        context.put(biz, map);
        start(exts);
    }

    private static void start(List<ExtensionPoint> pipe) {
        pipe.forEach(ExtensionPoint::handler);
    }

    private static ExtensionPoint getDefault(Class<ExtensionPoint> clazz) {
        // 获取默认扩展点策略1
        ExtensionPoint defaultExt = ExtensionHolder.getBean(clazz, ExtConstant.DEFAULT);
        if (defaultExt != null) {
            return defaultExt;
        }
        // 获取默认扩展点策略2
        // 任意一个实例 通过getDefault默认方法获取
        try {
            Map<String, ExtensionPoint> beansOfType = applicationContext.getBeansOfType(clazz);
            if (ObjectUtils.isEmpty(beansOfType)) {
                String msg = String.format("当前扩展点无具体实现， interface = %s", clazz);
                throw new RuntimeException(msg);
            }
            defaultExt = (ExtensionPoint) beansOfType
                    .entrySet()
                    .stream()
                    .map(Map.Entry::getValue)
                    .findFirst()
                    // is not null
                    .get()
                    .getDefault();
        } catch (Exception ex) {
            String msg = String.format("获取默认扩展点失败, interface = %s", clazz);
            log.error(msg, ex);
            throw new RuntimeException(msg);
        }

        if (defaultExt == null) {
            String msg = String.format("获取默认扩展点失败, interface = %s", clazz);
            throw new RuntimeException(msg);
        }
        return defaultExt;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PipelineHelper.applicationContext = applicationContext;
    }

}
