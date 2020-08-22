package com.github.dingey.auth.web;

import com.github.dingey.auth.AuthResult;
import com.github.dingey.auth.model.Insert;
import com.github.dingey.auth.model.SysPermission;
import com.github.dingey.auth.model.Update;
import com.github.dingey.auth.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SysPermissionController {
    private final SysPermissionService sysPermissionService;

    @Autowired
    public SysPermissionController(SysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    @GetMapping(path = "/sys/permission/list")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView("/sys/permission/list");
        List<SysPermission> list = sysPermissionService.listOrderBySequence();
        view.addObject("list", list);
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

    @ResponseBody
    @PostMapping(path = "/sys/permission/sort")
    public String sort(Long id, Long pid, int index) {
        SysPermission p = sysPermissionService.get(id);
        sysPermissionService.updateOriginal(p.getPid(), p.getSequence());
        sysPermissionService.updateTarget(pid, index);
        p = new SysPermission();
        p.setId(id);
        p.setPid(pid);
        p.setSequence(index);
        sysPermissionService.update(p);
        return "success";
    }

    @ResponseBody
    @PostMapping(path = "/sys/permission/sorts")
    public AuthResult<Integer> update(String ids) {
        if (StringUtils.hasText(ids)) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                sysPermissionService.updateSequence(Long.valueOf(split[i]), i);
            }
        }
        return AuthResult.success(1);
    }

    @ResponseBody
    @GetMapping(path = "/sys/permission/add")
    public Object add(Long pid) {
        SysPermission p = new SysPermission();
        p.setPid(pid);
        p.setSequence(sysPermissionService.countByParentId(pid));
        sysPermissionService.save(p);
        return p.getId();
    }

    @ResponseBody
    @PostMapping(path = "/sys/permission/del")
    public Object del(Long id) {
        SysPermission sp=new SysPermission();
        sp.setId(id);
        sp.setIsDel(1);
        return  sysPermissionService.update(sp);
    }
}
