package web.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.demo.domain.dto.TableInfoParam;
import web.demo.domain.entity.TableInfo;
import web.demo.exception.BaseException;
import web.demo.service.TableInfoServiceImpl;

/**
 * @author sunc
 * @date 2019/11/15 18:55
 * @description TableInfoTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableInfoTest {

    @Autowired
    private TableInfoServiceImpl tableInfoService;

    @Test
    public void create() {
        System.out.println(("----- selectAll method test ------"));

        String tbl = "{\"talName\":\"test name\"}";
        try {
            TableInfoParam t = TableInfoParam.init(tbl);
            TableInfo table = tableInfoService.insert(t);
            Assert.assertEquals(1L, (long) table.getId());
        } catch (BaseException e) {
            System.out.println(e.errCode);
            System.out.println(e.message);
        }

    }

}

