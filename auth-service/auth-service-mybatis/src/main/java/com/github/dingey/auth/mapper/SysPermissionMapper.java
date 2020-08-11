package com.github.dingey.auth.mapper;

import com.github.dingey.auth.model.SysPermission;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    @Update("update sys_permission set sequence=sequence-1 where pid=#{parentId} and sequence>#{sequence} and is_del=0")
    Integer updateOriginal(@Param("parentId") Long parentId, @Param("sequence") int sequence);

    @Update("update sys_permission set sequence=sequence+1 where pid=#{parentId} and sequence>=#{sequence} and is_del=0")
    Integer updateTarget(@Param("parentId") Long parentId, @Param("sequence") int sequence);

    @Update("update sys_permission set `sequence`=#{sequence} where id=#{id}")
    Integer updateSequence(@Param("id") Long id, @Param("sequence") Integer sequence);

    @Select("select * from sys_permission where is_del=0 order by sequence asc")
    List<SysPermission> listOrderBySequence();

    @Select("select count(0) from sys_permission where pid=#{parentId} and is_del=0")
    Integer countByParentId(int parentId);

}
