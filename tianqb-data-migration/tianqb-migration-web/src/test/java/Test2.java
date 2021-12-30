import cn.tianqb.migration.domain.MigrationEntity;
import cn.tianqb.migration.web.handler.AbstractHandler;
import org.junit.Test;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 10:01
 */
public class Test2 {

    @Test
    public void test() {
        MigrationEntity entity = new MigrationEntity();
        entity.setQuery("xxx");

        AbstractHandler handler = new AbstractHandler.Builder()
                .build();

        handler.run();
    }

}
