package com.github.dingey.auth.service;

import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.vo.IdNameVO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SysGroupService extends AuthBaseService<SysGroup> {
    List<SysGroup> listWithChild(Long pid, Long ledUid);

    Map<Long, IdNameVO> getGroupNames(Collection<Long> ids);
}
