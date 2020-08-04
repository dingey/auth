package com.github.dingey.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("用户")
public class SysUser extends BaseEntity<SysUser> {

    @NotEmpty(groups = Insert.class)
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String salt;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String password;

    @NotNull(groups = Insert.class)
    @ApiModelProperty("所属组织")
    private Long groupId;

    @ApiModelProperty("过期时间")
    private Date expireTime;

    @ApiModelProperty("是否锁定")
    private Integer isLocked;

}