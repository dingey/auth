package com.github.dingey.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SysIndexController {
    @GetMapping(path = "/sys/index")
    public ModelAndView blank() {
        return new ModelAndView("/sys/common/blank");
    }
}
