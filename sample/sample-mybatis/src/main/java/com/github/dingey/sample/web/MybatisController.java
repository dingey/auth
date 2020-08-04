package com.github.dingey.sample.web;

import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.service.SysGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MybatisController {
    @ApiOperation("测试获取")
    @GetMapping(path = "/mybatis/user")
    public String get() {
        return "aaaa";
    }

    @Resource
    SysGroupService sysGroupService;

    @ApiOperation("测试获取")
    @GetMapping(path = "/sysGroup/listWithChild")
    public List<SysGroup> listWithChild(Long pid, Long ledUid) {
        return sysGroupService.listWithChild(pid, ledUid);
    }
}
