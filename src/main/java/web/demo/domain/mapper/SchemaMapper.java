package web.demo.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.demo.base.Constant;

import java.util.List;

/**
 * @author sunc
 * @date 2019/11/15 18:17
 * @description SchemaMapper
 */

@Mapper
public interface SchemaMapper {

    /**
     * get scheme
     *
     * @return schema list
     */
    @Select(Constant.SCHEMA_SQL)
    List<String> getTableWithTenantFk();

}
