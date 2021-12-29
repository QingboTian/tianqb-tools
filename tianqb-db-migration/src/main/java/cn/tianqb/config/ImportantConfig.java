package cn.tianqb.config;

import com.jd.security.configsec.spring.config.JDSecurityPropertyCleanService;
import com.jd.security.configsec.spring.config.JDSecurityPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:important.properties", encoding = "utf-8", factory = JDSecurityPropertySourceFactory.class)
@Import(JDSecurityPropertyCleanService.class)
public class ImportantConfig {
}
