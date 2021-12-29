package cn.tianqb.common.extension.config;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.common.extension.processor.BusinessExtProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
@Configuration
@ConditionalOnMissingBean(value = BusinessExtProcessor.class)
@Import(BusinessExtProcessor.class)
public class ContextAutoConfiguration {
    @Bean
    public ExtensionHolder createClassifyHolder() {
        return new ExtensionHolder();
    }
}
