package com.github.dingey.auth.mapper;

import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.vo.IdNameVO;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface SysGroupMapper extends BaseMapper<SysGroup> {
    /**
     * 查询指定主管下的所有组织
     *
     * @param pid    上级组织ID
     * @param ledUid 主管ID
     * @return 指定主管下的所有组织
     */
    @Select("<script>WITH RECURSIVE chd AS " +
            "( " +
            " SELECT t1.* FROM sys_group t1 WHERE 1=1 " +
            "<if test='pid!=null'>and pid=#{pid}</if> " +
            "<if test='ledUid!=null'> and led_uid=#{ledUid}</if>" +
            "    UNION ALL " +
            " SELECT t2.* FROM chd,sys_group t2 WHERE t2.pid=chd.Id " +
            ") " +
            "SELECT DISTINCT * FROM chd</script>")
    List<SysGroup> listWithChild(@Param("pid") Long pid, @Param("ledUid") Long ledUid);

    /**
     * 查询主管对组织是否有编辑权限，(组织无主管/主管为当前用户/组织所属上级组织为当前用户主管)
     *
     * @param ledUid 主管ID
     * @return 0无1有
     */
    @Select("<script>WITH RECURSIVE chd AS " +
            "( " +
            " SELECT t1.* FROM sys_group t1 WHERE 1=1 " +
            "<if test='ledUid!=null'> and (led_uid=0 OR led_uid=#{ledUid})</if>" +
            "    UNION ALL " +
            " SELECT t2.* FROM chd,sys_group t2 WHERE t2.pid=chd.Id " +
            ") " +
            "SELECT count(DISTINCT id) FROM chd WHERE child.id=#{id}</script>")
    Integer canEdit(@Param("ledUid") Long ledUid, @Param("id") Long id);

    @MapKey("id")
    @Select("<script>select id,name from sys_group where id in <foreach collection=\"ids\" open=\"(\" close=\")\" separator=\",\" item=\"id\">#{id}</foreach></script>")
    Map<Long, IdNameVO> getGroupNames(@Param("ids") Collection<Long> ids);
}
