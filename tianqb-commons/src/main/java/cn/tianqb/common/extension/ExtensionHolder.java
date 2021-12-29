package cn.tianqb.common.extension;

import cn.tianqb.common.extension.aware.GlobalContextAware;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public class ExtensionHolder implements GlobalContextAware {
    private static GlobalContext globalContext;

    /**
     * @param tClass
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass, String key) {
        return globalContext.getExtBeanByKey(tClass, key);
    }

    @Override
    public void setGlobalContext(GlobalContext globalContext) {
        ExtensionHolder.globalContext = globalContext;
    }
}
