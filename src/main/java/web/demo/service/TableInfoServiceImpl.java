package web.demo.service;

import org.springframework.stereotype.Service;
import web.demo.domain.dto.TableInfoParam;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.entity.TableInfo;
import web.demo.domain.repository.TableInfoRepo;
import web.demo.mapper.TableInfoMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoServiceImpl
 */

@Service
public class TableInfoServiceImpl implements TableInfoRepo {

    @Resource
    private TableInfoMapper tableInfoMapper;
    @Resource
    private ColumnInfoServiceImpl columnInfoService;

    public TableInfo insert(TableInfoParam tableInfoParam) {
        TableInfo tableInfo = tableInfoParam.getTable();
        tableInfoMapper.insert(tableInfo);
        List<ColumnInfo> columns = tableInfoParam.getColumns(tableInfo.getFk());
        columnInfoService.inserts(columns);
        return tableInfo;
    }

    @Override
    public TableInfo insert(TableInfo tableInfo) {
        tableInfoMapper.insert(tableInfo);
        return tableInfo;
    }

}
