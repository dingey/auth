package com.github.dingey.auth.web;

import com.github.dingey.auth.service.SysGroupService;
import com.github.dingey.auth.vo.SysUserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnProperty(value = "auth.web-type", havingValue = "rest", matchIfMissing = true)
@RestController
public class SysUserRestController {

    @ApiOperation("获取系统用户信息")
    @GetMapping(path = "/sys/user/{id}")
    public SysUserVo get(@PathVariable Long id) {
        SysUserVo userVo = new SysUserVo();
        userVo.setId(id);
        return userVo;
    }
}
