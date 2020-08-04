package com.github.dingey.auth.service;

import com.github.dingey.auth.model.SysRole;

import java.util.List;

public interface SysRoleService extends AuthBaseService<SysRole> {
    /**
     * 获取用户管理下的所有角色
     *
     * @param uid 用户ID
     * @return 用户管理下的所有角色
     */
    List<SysRole> listByUid(Long uid);
}
