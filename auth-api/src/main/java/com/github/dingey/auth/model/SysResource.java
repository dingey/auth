package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 资源
 *
 * @author d
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("资源")
public class SysResource extends BaseEntity<SysResource> {

    @ApiModelProperty("类型：0url路径；1其他")
    private Integer type;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("编码")
    private String code;

}