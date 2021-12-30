package cn.tianqb.migration.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:11
 */
//@Configuration
public class JdbcTemplateConfig {

    @Bean
    public JdbcTemplate source(@Qualifier("dbSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate target(@Qualifier("dbTarget") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
