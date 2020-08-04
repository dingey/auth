package com.github.dingey.auth.service;

import com.github.dingey.auth.mapper.SysRoleMapper;
import com.github.dingey.auth.model.SysRole;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.List;

@ConditionalOnBean(MybatisAutoConfiguration.class)
@Service
public class SysRoleServiceImpl extends AuthBaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public List<SysRole> listByUid(Long uid) {
        return mapper.listByUid(uid);
    }
}
