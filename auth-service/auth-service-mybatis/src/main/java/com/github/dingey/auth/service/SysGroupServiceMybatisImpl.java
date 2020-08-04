package com.github.dingey.auth.service;

import com.github.dingey.auth.mapper.SysGroupMapper;
import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.vo.IdNameVO;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ConditionalOnBean(MybatisAutoConfiguration.class)
@Service
public class SysGroupServiceMybatisImpl extends AuthBaseServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {
    @PostConstruct
    public void init() {
        log.info("Initializing Auth Mybatis Service");
    }

    @Override
    public List<SysGroup> listWithChild(Long pid, Long ledUid) {
        return mapper.listWithChild(pid, ledUid);
    }

    @Override
    public Map<Long, IdNameVO> getGroupNames(Collection<Long> ids) {
        if(ids==null||ids.isEmpty()){
            return Collections.emptyMap();
        }
        return mapper.getGroupNames(ids);
    }
}
