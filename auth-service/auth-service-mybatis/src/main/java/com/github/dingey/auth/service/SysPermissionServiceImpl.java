package com.github.dingey.auth.service;

import com.github.dingey.auth.mapper.SysPermissionMapper;
import com.github.dingey.auth.model.SysPermission;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.List;

@ConditionalOnBean(MybatisAutoConfiguration.class)
@Service
public class SysPermissionServiceImpl extends AuthBaseServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
    @Override
    public Integer updateOriginal(Long parentId, int index) {
        return mapper.updateOriginal(parentId, index);
    }

    @Override
    public Integer updateTarget(Long parentId, int index) {
        return mapper.updateTarget(parentId, index);
    }

    @Override
    public Integer updateSequence(Long id, int index) {
        return mapper.updateSequence(id, index);
    }

    @Override
    public List<SysPermission> listOrderBySequence() {
        return mapper.listOrderBySequence();
    }

    @Override
    public Integer countByParentId(Long parentId) {
        return null;
    }
}
