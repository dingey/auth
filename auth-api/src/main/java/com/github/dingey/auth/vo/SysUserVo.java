package com.github.dingey.auth.vo;

import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.model.SysRole;
import com.github.dingey.auth.model.SysUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SysUserVo extends SysUser {

    private SysGroup sysGroup;

    private List<SysRole> roles;
}