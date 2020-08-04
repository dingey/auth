package com.github.dingey.auth.web;

import com.github.dingey.auth.AuthPager;
import com.github.dingey.auth.model.SysGroup;
import com.github.dingey.auth.service.SysGroupService;
import com.github.dingey.auth.service.SysUserService;
import com.github.dingey.auth.util.FreemarkerUtil;
import com.github.dingey.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SysGroupController {
    private final SysGroupService sysGroupService;
    private final SysUserService sysUserService;

    @Autowired
    public SysGroupController(SysGroupService sysGroupService, SysUserService sysUserService) {
        this.sysGroupService = sysGroupService;
        this.sysUserService = sysUserService;
    }

    @GetMapping(path = "/sys/group/list")
    public ModelAndView list(SysGroup group,
                             @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView view = new ModelAndView("/sys/group/list");
        AuthPager<SysGroup> pager = sysGroupService.pager(group, pageNum, pageSize);
        Map<String, String> userNames = FreemarkerUtil.toStringKeyValue(sysUserService.listUserNames(null), "name");
        view.addObject("userNames", userNames);
        view.addObject("pager", pager);
        return view;
    }

    @GetMapping(path = "/sys/group/get")
    public ModelAndView get(Long id) {
        ModelAndView view = new ModelAndView("/sys/group/get");
        SysGroup group = sysGroupService.get(id);
        view.addObject("group", group);
        return view;
    }

    @ResponseBody
    @PostMapping(path = "/sys/group/save")
    public Result<Integer> save(SysGroup group) {
        int save = sysGroupService.save(group);
        return Result.success(save);
    }
}
