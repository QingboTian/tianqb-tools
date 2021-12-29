import cn.tianqb.Application;
import cn.tianqb.entity.DataSourceEntity;
import cn.tianqb.entity.MigrationEntity;
import cn.tianqb.pipe.Pipeline;
import cn.tianqb.service.MigrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 15:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test1 {

    @Autowired
    private MigrationService migrationService;

    @Autowired
    @Qualifier("dataSourceCreatePipeline")
    private Pipeline pipeline;

    @Test
    public void test1() {
        MigrationEntity entity = new MigrationEntity();
        entity.setQuery("select id, name from test_from");
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        DataSourceEntity.Config config = new DataSourceEntity.Config();
        config.setTable("test_target");
        dataSourceEntity.setTarget(config);
        entity.setDataSource(dataSourceEntity);
        List<MigrationEntity.Field> mapping = new ArrayList<>();
        mapping.add(new MigrationEntity.Field("id", "id"));
        mapping.add(new MigrationEntity.Field("name", "name"));
        entity.setMapping(mapping);
        entity.setBatchSize(2);
        migrationService.run(entity);
    }

    @Test
    public void test2() {
        System.out.println();
    }

}
