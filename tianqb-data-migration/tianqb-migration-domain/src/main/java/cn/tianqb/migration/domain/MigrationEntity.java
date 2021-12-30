package cn.tianqb.migration.domain;

import lombok.*;

import java.util.List;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:14
 */
@Getter
@Setter
@ToString
public class MigrationEntity {

    private DataSourceEntity dataSource;

    /**
     * 查询语句
     */
    private String query;

    /**
     * 数据映射关系
     */
    private List<Field> mapping;

    /**
     * 批量插入大小
     */
    private Integer batchSize;

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Field {
        /**
         * 源字段
         */
        private String source;
        /**
         * 目标字段
         */
        private String target;
        /**
         * 初始值
         */
        private Object value;

        public Field(String source, String target) {
            this.source = source;
            this.target = target;
        }
    }
}
