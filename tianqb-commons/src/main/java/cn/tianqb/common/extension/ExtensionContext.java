package cn.tianqb.common.extension;

import java.util.Map;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public interface ExtensionContext<K, H> {
    /**
     * 组件注册
     *
     * @param k
     * @param h
     * @return
     */
    ExtensionContext<K, H> regist(K k, H h);

    /**
     * 组建注册
     *
     * @param map
     * @return
     */
    ExtensionContext<K, H> regist(Map<K, H> map);

    ExtensionContext<K, H> registIfAbsent(Map<K, H> map);

    /**
     * 单个组件获取
     *
     * @param k
     * @return
     */
    H get(K k);

    /**
     * 获取所有组件
     *
     * @return
     */
    Map<K, H> getMapping();
}
