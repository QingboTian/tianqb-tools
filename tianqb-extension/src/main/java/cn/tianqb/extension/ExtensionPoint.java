package cn.tianqb.extension;

/**
 * 标记接口所有的扩展点都应该去实现它
 */
public interface ExtensionPoint<T> {

    /**
     * 获取默认的扩展点
     * @return
     */
    T getDefault();

    void handler();
}
