package web.demo.service;

import org.springframework.stereotype.Service;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.mapper.ColumnInfoMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoServiceImpl
 */

@Service
public class ColumnInfoServiceImpl {

    @Resource
    private ColumnInfoMapper columnInfoMapper;

    public void inserts(List<ColumnInfo> columns) {
        columns.forEach(this::insert);
    }

    public void insert(ColumnInfo column) {
        columnInfoMapper.insert(column);
    }

    public List<ColumnInfo> selectByTbl(Long tblFk) {
        return columnInfoMapper.selectByTbl(tblFk);
    }

}
