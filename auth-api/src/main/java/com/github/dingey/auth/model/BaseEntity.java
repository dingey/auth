package com.github.dingey.auth.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseEntity<T> implements Serializable {
    @Id
    @ApiModelProperty(example = "0")
    private Long id;

    //@NotNull(groups = {Update.class}, message = "修改时间不能为空")
    @ApiModelProperty("最后修改时间")
    private Date lastModified;

    //@NotNull(groups = {Insert.class}, message = "创建时间不能为空")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty(example = "0")
    @NotNull(groups = {Insert.class}, message = "删除不能为空")
    private Integer isDel;

//    @ApiModelProperty(hidden = true)
//    @JsonIgnore
//    private String order = " order by id asc";
}
