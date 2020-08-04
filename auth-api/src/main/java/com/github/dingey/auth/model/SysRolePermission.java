package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 角色权限
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("角色权限")
public class SysRolePermission extends BaseEntity<SysRolePermission> {

    private Long permissionId;

    private Long roleId;

}