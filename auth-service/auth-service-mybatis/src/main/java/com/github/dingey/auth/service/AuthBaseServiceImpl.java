package com.github.dingey.auth.service;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.model.BaseEntity;
import com.github.dingey.mybatis.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AuthBaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> implements AuthBaseService<T> {
    @Autowired
    M mapper;
    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public T get(Serializable id) {
        return mapper.get(id);
    }

    @Override
    public List<T> list(T t) {
        return mapper.list(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public AuthPager<T> pager(T t, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.list(t);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return AuthPager.of(pageInfo);
    }

    @Override
    public int save(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public int update(T t) {
        return mapper.updateSelective(t);
    }
}
