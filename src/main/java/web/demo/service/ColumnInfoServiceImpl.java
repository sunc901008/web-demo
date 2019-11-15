package web.demo.service;

import org.springframework.stereotype.Service;
import web.demo.domain.entity.ColumnInfo;
import web.demo.domain.repository.ColumnInfoRepo;
import web.demo.mapper.ColumnInfoMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoServiceImpl
 */

@Service
public class ColumnInfoServiceImpl implements ColumnInfoRepo {

    @Resource
    private ColumnInfoMapper columnInfoMapper;

    @Override
    public void inserts(List<ColumnInfo> columns) {
        columns.forEach(this::insert);
    }

    @Override
    public void insert(ColumnInfo column) {
        columnInfoMapper.insert(column);
    }
}
