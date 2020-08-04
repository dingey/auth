package com.github.dingey.auth.mapper;

import com.github.dingey.auth.model.SysRole;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 获取用户管理下的所有角色
     *
     * @param uid 用户ID
     * @return 用户管理下的所有角色
     */
    @Select("SELECT * FROM sys_role WHERE  " +
            "group_id IN (WITH RECURSIVE child AS ( SELECT t1.* FROM sys_group t1 WHERE t1.led_uid =#{uid} UNION ALL SELECT t2.* FROM child, sys_group t2 WHERE t2.pid = child.Id ) SELECT DISTINCT id FROM child )")
    List<SysRole> listByUid(Long uid);
}
