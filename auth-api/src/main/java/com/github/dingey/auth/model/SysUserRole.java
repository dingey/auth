package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 用户角色
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("用户角色")
public class SysUserRole extends BaseEntity<SysUserRole> {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;

}