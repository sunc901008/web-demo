package web.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.demo.domain.entity.TableInfo;
import web.demo.domain.mapper.TableInfoMapper;
import web.demo.domain.param.TableInfoParam;
import web.demo.domain.vo.TblDetailVO;
import web.demo.exception.BaseException;
import web.demo.service.TableInfoServiceImpl;

import javax.annotation.Resource;

/**
 * @author sunc
 * @date 2019/11/15 18:55
 * @description TableInfoTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableInfoTest {

    @Resource
    private TableInfoServiceImpl tableInfoService;
    @Resource
    private TableInfoMapper tableInfoMapper;

    private long tblId;
    private static String tblName = "testTblName";
    private static String colName = "testColName";
    private static String tblInfo;

    @BeforeClass
    public static void tableInfo() {
        JSONObject json = new JSONObject();
        json.put("talName", tblName);
        JSONArray columns = new JSONArray();
        JSONObject col = new JSONObject();
        col.put("colName", colName);
        columns.add(col);
        json.put("columns", columns);
        tblInfo = json.toJSONString();
    }

    /**
     * 创建表信息
     */
    @Before
    public void init() {
        System.out.println(("----- create table ------"));
        try {
            TableInfoParam t = TableInfoParam.init(tblInfo);
            TableInfo table = tableInfoService.insert(t);
            tblId = table.getId();
            Assert.assertEquals(tblName, table.getTblName());
            System.out.println(String.format("create table success. tblId: %s tblName: %s", tblId, tblName));
        } catch (BaseException e) {
            System.out.println(e.errCode);
            System.out.println(e.message);
        }
    }

    /**
     * 删除表信息
     */
    @After
    public void clear() {
        System.out.println(("----- delete table ------"));
        int delete = tableInfoMapper.deleteById(tblId);
        Assert.assertEquals(1, delete);
        System.out.println(String.format("delete table success. tblId: %s", tblId));
    }

    /**
     * 根据id查询表信息
     */
    @Test
    public void selectById() {
        System.out.println("----- table selectById test ------");
        TblDetailVO table = tableInfoService.selectById(tblId);
        Assert.assertEquals(tblName, table.getTblName());
        Assert.assertEquals(1, table.getColumns().size());
        Assert.assertEquals(colName, table.getColumns().get(0).getColName());
        System.out.println(String.format("table selectById. table: %s ", table.toString()));
    }

    /**
     * 更新表名
     */
    @Test
    public void updateTblName() {
        System.out.println("----- table update tblName test ------");
        TableInfo table = tableInfoMapper.selectById(tblId);
        String updateTblName = "updateTblName";
        table.setTblName(updateTblName);
        int update = tableInfoMapper.updateById(table);
        Assert.assertEquals(1, update);
        System.out.println(String.format("table update. table: %s ", table.toJsonString()));
    }

}

