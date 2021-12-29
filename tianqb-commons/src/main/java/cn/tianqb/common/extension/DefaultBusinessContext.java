package cn.tianqb.common.extension;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public class DefaultBusinessContext<K, T> extends AbstractContext<K, T> {
    @Override
    protected void duplicateRegistHandle(K k, T t) {
        String format = String.format("@Classify field [key] repeat, key = %s, class = %s", k, t.getClass());
        throw new RuntimeException(format);
    }
}
