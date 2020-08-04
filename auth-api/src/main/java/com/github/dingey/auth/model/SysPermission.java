package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 权限
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("权限")
public class SysPermission extends BaseEntity<SysPermission> {

    @ApiModelProperty("上级")
    private Long pid;

    @ApiModelProperty("服务名称")
    private String service;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String desc;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("路径")
    private String url;
}