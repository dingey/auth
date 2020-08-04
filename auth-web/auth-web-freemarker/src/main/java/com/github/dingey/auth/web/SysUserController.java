package com.github.dingey.auth.web;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.model.SysUser;
import com.github.dingey.auth.service.SysUserService;
import com.github.dingey.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SysUserController {
    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @GetMapping(path = "/sys/user/list")
    public ModelAndView list(SysUser user,
                             @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView view = new ModelAndView("/sys/user/list");
        AuthPager<SysUser> pager = sysUserService.pager(user, pageNum, pageSize);
        view.addObject("pager", pager);
        return view;
    }

    @GetMapping(path = "/sys/user/get")
    public ModelAndView get(Long id) {
        ModelAndView view = new ModelAndView("/sys/user/get");
        SysUser user = sysUserService.get(id);
        view.addObject("user", user);
        return view;
    }

    @ResponseBody
    @PostMapping(path = "/sys/user/save")
    public Result<Integer> save(SysUser user) {
        int save = sysUserService.save(user);
        return Result.success(save);
    }
}
