package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 系统操作日志
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("系统操作日志")
public class SysOperateLog extends BaseEntity<SysOperateLog> {

    @ApiModelProperty("操作人")
    private Long sysUid;

    @ApiModelProperty("操作主题")
    private String topic;

    @ApiModelProperty("操作内容")
    private String content;
}