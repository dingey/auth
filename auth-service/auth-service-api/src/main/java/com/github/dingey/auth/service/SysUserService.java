package com.github.dingey.auth.service;

import com.github.dingey.auth.model.SysUser;
import com.github.dingey.auth.vo.IdNameVO;

import java.util.Map;

public interface SysUserService extends AuthBaseService<SysUser> {
    Map<Long, IdNameVO> listUserNames(String name);
}
