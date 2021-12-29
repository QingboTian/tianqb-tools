package cn.tianqb.entity.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 20:11
 */
@Getter
@Setter
@ToString
public class MysqlDataSource extends AbstractDataSource<JdbcTemplate> {
    /**
     * driver
     */
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private JdbcTemplate template;

    @Override
    public JdbcTemplate getConnect() {
        template = new JdbcTemplate();
        template.setDataSource(getDruidDataSource());
        return template;
    }

    private DruidDataSource getDruidDataSource() {
        validation();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(super.username);
        druidDataSource.setPassword(super.password);
        druidDataSource.setUrl(super.url);
        druidDataSource.setDriverClassName(DRIVER);
        druidDataSource.setConnectionErrorRetryAttempts(2);
        druidDataSource.setFailFast(true);
        druidDataSource.setBreakAfterAcquireFailure(true);
        return druidDataSource;
    }

    @Override
    void close() {
    }
}
