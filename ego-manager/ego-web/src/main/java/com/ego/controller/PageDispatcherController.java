package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName PageDispactherController
 * Description:
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-13-16:07
 */
@Controller
@RequestMapping("page")
public class PageDispatcherController {

    @RequestMapping("/{page}")
    public String toIndex(@PathVariable String url){
        return url;
    }

    @RequestMapping("toWelcome")
    public String toWelcome(){
        return "welcome";
    }
}
