package cn.tianqb.migration.ext.impl;

import cn.tianqb.common.exception.SystemException;
import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.ext.sdk.datasource.DataSourceAuthExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 16:42
 */
@Component
@Slf4j
@Extension(extClass = DataSourceAuthExt.class, key = ExtConstant.DATA_SOURCE_MYSQL)
public class MysqlDataSourceAuthExtImpl implements DataSourceAuthExt{
    @Override
    public void handler() {
        DataSource dataSource = Context.get("dataSource", DataSource.class);
        Connection connection = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
            connection.close();
        } catch (Exception e) {
            log.error("MYSQL连接失败", e);
            throw new SystemException(HttpStatus.UNAUTHORIZED.value(), "MYSQL连接失败");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("数据库关闭连接失败", e);
                }
            }
        }
    }
}
