package com.github.dingey.auth.web;

import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.service.SysGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnProperty(value = "auth.web-type", havingValue = "rest")
@RestController
public class SysGroupRestController {
    @Autowired
    private SysGroupService sysGroupService;

    @ApiOperation("获取系统组织信息")
    @GetMapping(path = "/sys/group/{id}")
    public SysGroup get(@PathVariable Long id) {
        return sysGroupService.get(id);
    }
}
