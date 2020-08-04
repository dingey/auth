package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 组织
 *
 * @author d
 */
@Getter
@Setter
@ApiModel("组织")
@Accessors(chain = true)
public class SysGroup extends BaseEntity<SysGroup> {

    @NotNull(message = "上级不能为空", groups = Insert.class)
    @ApiModelProperty("上级")
    private Long pid;

    @NotNull(message = "上级不能为空", groups = Insert.class)
    @ApiModelProperty("主管")
    private Long ledUid;

    @NotEmpty
    @ApiModelProperty("组织名称")
    private String name;
}