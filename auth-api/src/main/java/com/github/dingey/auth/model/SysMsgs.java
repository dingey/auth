package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 系统消息
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("系统消息")
public class SysMsgs extends BaseEntity<SysMsgs> {

    @ApiModelProperty("发送者")
    private Long senderUid;

    @ApiModelProperty("接收者")
    private Long receiverUid;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("是否已读")
    private Integer isRead;
}