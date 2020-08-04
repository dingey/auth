package com.github.dingey.auth.service;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface AuthBaseService<T extends BaseEntity> {
    T get(Serializable id);

    List<T> list(T t);

    AuthPager<T> pager(T t, int pageNum, int pageSize);

    int save(T t);

    int update(T t);
}
