package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 权限资源
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("权限资源")
public class SysPermissionResource extends BaseEntity<SysPermissionResource> {

    private Long permissionId;

    private Long resourceId;
}