package web.demo.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import web.demo.domain.entity.ColumnInfo;

import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description TableInfoMapper
 */

public interface ColumnInfoMapper extends BaseMapper<ColumnInfo> {

    /**
     * 根据表查找列
     *
     * @param tblFk table foreign key
     * @return column list
     */
    @Select("SELECT * FROM column_info WHERE tbl_fk = #{tblFk}")
    List<ColumnInfo> selectByTbl(Long tblFk);

}
