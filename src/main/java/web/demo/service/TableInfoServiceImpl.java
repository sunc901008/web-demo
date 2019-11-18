package web.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.entity.TableInfo;
import web.demo.domain.mapper.ColumnInfoMapper;
import web.demo.domain.mapper.TableInfoMapper;
import web.demo.domain.param.TableInfoParam;
import web.demo.domain.vo.TblDetailVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoServiceImpl
 */

@Service
@Transactional(propagation = Propagation.NESTED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
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
        List<ColumnInfo> columns = columnInfoMapper.selectByTbl(tableInfo.getFk());
        return new TblDetailVO(tableInfo, columns);
    }

}
