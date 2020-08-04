package com.github.dingey.auth.mapper;

import com.github.dingey.auth.model.SysUser;
import com.github.dingey.auth.vo.IdNameVO;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @MapKey("id")
    @Select("<script>select id,name from sys_user <if test=\"name!=null and name !=''\"> where name like name</if></script>")
    Map<Long, IdNameVO> listUserNames(String name);
}
