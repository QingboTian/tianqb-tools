package cn.tianqb.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 10:00
 */
@Slf4j
public class DefaultConnectValidHandler extends AbstractMigrationHandler {

    public DefaultConnectValidHandler() {
    }

    @Override
    public void handler() {
        log.info("连接情况判断");
    }
}
