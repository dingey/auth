package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 角色
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("角色")
public class SysRole extends BaseEntity<SysRole> {
    @NotNull(groups = Insert.class)
    @ApiModelProperty("上级角色")
    private Long pid;

    @NotNull(groups = Insert.class)
    @ApiModelProperty("组织ID")
    private Long groupId;

    @NotEmpty
    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("描述")
    private String desc;

}