package cn.tianqb.migration.web.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:08
 */
//@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.source")
    public DataSource dbSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.target")
    public DataSource dbTarget() {
        return DruidDataSourceBuilder.create().build();
    }

}
