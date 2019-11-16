package web.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.demo.domain.param.TableInfoParam;
import web.demo.domain.entity.TableInfo;
import web.demo.domain.vo.TblDetailVO;
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

    private long tblId;
    private String tblName = "testTblName";
    private String colName = "testColName";

    @Test
    public void create() {
        System.out.println(("----- create table test ------"));
        JSONObject json = new JSONObject();
        json.put("talName", tblName);
        JSONArray columns = new JSONArray();
        JSONObject col = new JSONObject();
        col.put("colName", colName);
        columns.add(col);
        json.put("columns", columns);
        try {
            TableInfoParam t = TableInfoParam.init(json.toJSONString());
            TableInfo table = tableInfoService.insert(t);
            tblId = table.getId();
            Assert.assertEquals(1, tblId);
        } catch (BaseException e) {
            System.out.println(e.errCode);
            System.out.println(e.message);
        }
    }

    @Test
    public void selectById() {
        System.out.println(("----- table selectById test ------"));
        TblDetailVO table = tableInfoService.selectById(tblId);
        Assert.assertEquals(tblName, table.getTblName());
        Assert.assertEquals(1, table.getColumns().size());
        Assert.assertEquals(colName, table.getColumns().get(0).getColName());
    }

}

