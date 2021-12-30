package cn.tianqb.migration.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@PropertySource(value = "classpath:important.properties", encoding = "utf-8", factory = JDSecurityPropertySourceFactory.class)
//@Import(JDSecurityPropertyCleanService.class)
@ImportResource(locations= {"classpath:pipeline.xml"})
public class ImportantConfig {
}
