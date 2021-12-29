package cn.tianqb.common.extension;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public abstract class AbstractContext<K, H> implements ExtensionContext<K, H> {
    /**
     * 组件上下文
     */
    private Map<K, H> contextMap;

    public AbstractContext() {
        contextMap = new ConcurrentHashMap<>(16);
    }

    public AbstractContext(Map<K, H> contextMap) {
        this.contextMap = contextMap;
    }

    /**
     * 组件注册
     *
     * @param k
     * @param h
     * @return
     */
    @Override
    public ExtensionContext<K, H> regist(K k, H h) {
        if (contextMap.putIfAbsent(k, h) != null) {
            duplicateRegistHandle(k, h);
        }
        return this;
    }

    /**
     * 重复注册处理
     *
     * @param k
     * @param h
     */
    protected void duplicateRegistHandle(K k, H h) {

    }

    /**
     * 组件注册
     *
     * @param map
     * @return
     */
    @Override
    public ExtensionContext<K, H> regist(Map<K, H> map) {
        contextMap.putAll(map);
        return this;
    }

    @Override
    public ExtensionContext<K, H> registIfAbsent(Map<K, H> map) {
        Optional.ofNullable(map).ifPresent(data -> data.forEach(this::regist));
        return this;
    }

    /**
     * 组件获取
     *
     * @param key
     * @return
     */
    @Override
    public H get(K key) {
        return contextMap.get(key);
    }

    /**
     * 获取所有组件
     *
     * @return
     */
    @Override
    public Map<K, H> getMapping() {
        return contextMap;
    }
}
