package com.github.dingey.auth.service;

import com.github.dingey.auth.model.SysPermission;

import java.util.List;

public interface SysPermissionService extends AuthBaseService<SysPermission> {
    Integer updateOriginal(Long parentId, int index);

    Integer updateTarget(Long parentId, int index);

    Integer updateSequence(Long valueOf, int i);

    List<SysPermission> listOrderBySequence();

    Integer countByParentId(Long parentId);
}
