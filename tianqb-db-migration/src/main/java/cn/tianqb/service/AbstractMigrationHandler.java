package cn.tianqb.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 9:45
 */
@Slf4j
public abstract class AbstractMigrationHandler implements Handler {

    private AbstractMigrationHandler next;

    @Override
    public void pre() {

    }

    @Override
    final public void run() {
        AbstractMigrationHandler current = this;
        while (current != null) {
            current.pre();
            current.handler();
            current.post();
            current = current.next;
        }
    }

    @Override
    public void post() {

    }

    public static class Builder {
        // chain head
        private AbstractMigrationHandler head = null;
        // chain tail
        private AbstractMigrationHandler tail = null;

        /**
         * 构建节点
         * @param next next node
         * @return builder
         */
        public Builder next(AbstractMigrationHandler next) {
            if (head == null) {
                head = tail = next;
            } else {
                tail.next = next;
                tail = next;
            }
            return this;
        }

        /**
         * 返回责任链头节点
         * @return head node
         */
        public AbstractMigrationHandler build() {
            return head;
        }
    }
}
