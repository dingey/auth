package com.github.dingey.auth.service;

import com.github.dingey.auth.mapper.SysUserMapper;
import com.github.dingey.auth.model.SysUser;
import com.github.dingey.auth.vo.IdNameVO;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.Map;

@ConditionalOnBean(MybatisAutoConfiguration.class)
@Service
public class SysUserServiceMybatisImpl extends AuthBaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Map<Long, IdNameVO> listUserNames(String name) {
        return mapper.listUserNames(name);
    }
}
