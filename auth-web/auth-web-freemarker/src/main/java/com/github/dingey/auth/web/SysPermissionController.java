package com.github.dingey.auth.web;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.AuthResult;
import com.github.dingey.auth.model.Insert;
import com.github.dingey.auth.model.SysPermission;
import com.github.dingey.auth.model.Update;
import com.github.dingey.auth.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SysPermissionController {
    private final SysPermissionService sysPermissionService;

    @Autowired
    public SysPermissionController(SysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    @GetMapping(path = "/sys/permission/list")
    public ModelAndView list(SysPermission permission,
                             @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView view = new ModelAndView("/sys/permission/list");
        AuthPager<SysPermission> pager = sysPermissionService.pager(permission, pageNum, pageSize);
        view.addObject("pager", pager);
        return view;
    }

    @GetMapping(path = "/sys/permission/get")
    public ModelAndView get(Long id) {
        ModelAndView view = new ModelAndView("/sys/permission/get");
        SysPermission permission = sysPermissionService.get(id);
        view.addObject("permission", permission);
        return view;
    }

    @ResponseBody
    @PostMapping(path = "/sys/permission/save")
    public AuthResult<Integer> save(@Validated(Insert.class) SysPermission permission) {
        int save = sysPermissionService.save(permission);
        return AuthResult.success(save);
    }

    @ResponseBody
    @PostMapping(path = "/sys/permission/update")
    public AuthResult<Integer> update(@Validated(Update.class) SysPermission permission) {
        int update = sysPermissionService.update(permission);
        return AuthResult.success(update);
    }
}
