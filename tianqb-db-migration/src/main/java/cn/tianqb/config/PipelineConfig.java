package cn.tianqb.config;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.entity.DataSource;
import cn.tianqb.ext.ExtensionPoint;
import cn.tianqb.pipe.Pipeline;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Map;

/**
 * 管道配置解析
 * 该配置类是主要确认管道节点的具体实现
 */
@Configuration
public class PipelineConfig implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() {
        Map<String, Pipeline> pipelineMap = applicationContext.getBeansOfType(Pipeline.class);
        // 获取所有的类型
        Arrays.stream(DataSource.Type.values())
                .forEach(type -> {
                    pipelineMap.forEach((id, pipe) -> {
                        pipe.getHandler().forEach(ext -> {
                            ExtensionPoint bean = ExtensionHolder.getBean(ext, type.getAlias());
                            if (bean == null) {
                                // 执行默认方法获取默认扩展点
                            }
                        });
                    });
                });

        System.out.println();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
