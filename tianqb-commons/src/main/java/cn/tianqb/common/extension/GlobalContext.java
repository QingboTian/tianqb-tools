package cn.tianqb.common.extension;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public class GlobalContext extends AbstractContext<Class<?>, ExtensionContext> {
    /**
     * 全局上下文中创建业务上下文并注册
     *
     * @param tClass
     * @param classfireContext
     * @param <T>
     * @param <K>
     */
    public <T, K> void createContext(Class<T> tClass, ExtensionContext<K, T> classfireContext) {
        if (this.get(tClass) != null) {
            this.get(tClass).registIfAbsent(classfireContext.getMapping());
        }
        this.regist(tClass, classfireContext);
    }

    /**
     * @param tClass
     * @param kClass
     * @param <T>
     * @param <K>
     * @return
     */
    public <T, K> ExtensionContext<K, T> getClassfireContext(Class<T> tClass, Class<K> kClass) {
        return this.get(tClass);
    }

    /**
     * @param tClass
     * @param key
     * @param <T>
     * @param <K>
     * @return
     */
    public <T, K> T getExtBeanByKey(Class<T> tClass, K key) {
        ExtensionContext extensionContext = this.get(tClass);
        if (extensionContext == null) {
            return null;
        }
        Object res = extensionContext.get(key);
        if (res == null) {
            return null;
        }
        return tClass.cast(res);
    }
}
