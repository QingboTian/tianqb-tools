import cn.tianqb.entity.MigrationEntity;
import cn.tianqb.service.*;
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
        HandlerContext.set(entity);

        AbstractMigrationHandler handler = new AbstractMigrationHandler.Builder()
                .next(new DefaultParamsValidHandler())
                .next(new DefaultInitHandler())
                .next(new DefaultConnectValidHandler())
                .build();

        handler.run();
    }

}
