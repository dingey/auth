package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 系统登录日志
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("系统登录日志")
public class SysLoginLog extends BaseEntity<SysLoginLog> {

    @ApiModelProperty("操作人")
    private Long sysUid;

    @ApiModelProperty("ip地址")
    private String ipAddress;
}