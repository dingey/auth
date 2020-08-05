package com.github.dingey.auth.web;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.AuthResult;
import com.github.dingey.auth.model.Insert;
import com.github.dingey.auth.model.SysRole;
import com.github.dingey.auth.model.Update;
import com.github.dingey.auth.service.SysGroupService;
import com.github.dingey.auth.service.SysRoleService;
import com.github.dingey.auth.util.FreemarkerUtil;
import com.github.dingey.auth.vo.IdNameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SysRoleController {
    private final SysRoleService sysRoleService;
    private final SysGroupService sysGroupService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService, SysGroupService sysGroupService) {
        this.sysRoleService = sysRoleService;
        this.sysGroupService = sysGroupService;
    }

    @GetMapping(path = "/sys/role/list")
    public ModelAndView list(SysRole role,
                             @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView view = new ModelAndView("/sys/role/list");
        AuthPager<SysRole> pager = sysRoleService.pager(role, pageNum, pageSize);
        Map<Long, IdNameVO> groupNames = sysGroupService.getGroupNames(pager.getList().stream().map(r -> r.getGroupId()).collect(Collectors.toList()));
        view.addObject("groupNames", FreemarkerUtil.toStringKeyValue(groupNames, "name"));
        view.addObject("pager", pager);
        return view;
    }

    @GetMapping(path = "/sys/role/get")
    public ModelAndView get(Long id) {
        ModelAndView view = new ModelAndView("/sys/role/get");
        SysRole role = sysRoleService.get(id);
        view.addObject("role", role);
        return view;
    }

    @ResponseBody
    @PostMapping(path = "/sys/role/save")
    public AuthResult<Integer> save(@Validated(Insert.class) SysRole role) {
        int save = sysRoleService.save(role);
        return AuthResult.success(save);
    }

    @ResponseBody
    @PostMapping(path = "/sys/role/update")
    public AuthResult<Integer> update(@Validated(Update.class) SysRole role) {
        int save = sysRoleService.update(role);
        return AuthResult.success(save);
    }
}
