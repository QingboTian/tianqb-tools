package cn.tianqb.service;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 9:42
 */
public interface Handler {

    /**
     * 前置处理
     */
    void pre();

    /**
     * start
     */
    void run();

    /**
     * handler
     */
    void handler();

    /**
     * 后置处理
     */
    void post();
}
