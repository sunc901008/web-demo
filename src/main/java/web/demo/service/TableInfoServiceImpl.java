package web.demo.service;

import org.springframework.stereotype.Service;
import web.demo.domain.mapper.ColumnInfoMapper;
import web.demo.domain.param.TableInfoParam;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.entity.TableInfo;
import web.demo.domain.mapper.TableInfoMapper;
import web.demo.domain.vo.TblBasicVO;
import web.demo.domain.vo.TblDetailVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoServiceImpl
 */

@Service
public class TableInfoServiceImpl {

    @Resource
    private TableInfoMapper tableInfoMapper;
    @Resource
    private ColumnInfoMapper columnInfoMapper;

    public TableInfo insert(TableInfoParam tableInfoParam) {
        TableInfo tableInfo = tableInfoParam.getTable();
        tableInfoMapper.insert(tableInfo);
        List<ColumnInfo> columns = tableInfoParam.getColumns(tableInfo.getFk());
        columns.forEach(columnInfoMapper::insert);
        return tableInfo;
    }

    public TblDetailVO selectById(Long id) {
        TableInfo tableInfo = tableInfoMapper.selectById(id);
        TblDetailVO tblDetailVO = tableInfo.tblDetailVO();
        List<ColumnInfo> columns = columnInfoMapper.selectByTbl(tableInfo.getFk());
        columns.forEach(col -> tblDetailVO.addColumnVO(col.columnInfoVO()));
        return tblDetailVO;
    }

}
