package cn.tianqb.entity.datasource;

import cn.tianqb.utils.Assert;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 20:36
 */
@Getter
@Setter
@ToString
public abstract class AbstractDataSource<T> {
    /**
     * username
     */
    protected String username;
    /**
     * password
     */
    protected String password;
    /**
     * url
     */
    protected String url;

    /**
     * 获取连接
     * @return t
     */
    abstract T getConnect();

    /**
     * 关闭连接
     */
    abstract void close();

    void validation() {
        Assert.isEmpty(this.username, "data source username is empty");
        Assert.isEmpty(this.password, "data source password is empty");
        Assert.isEmpty(this.url, "data source url is empty");
    }
}
