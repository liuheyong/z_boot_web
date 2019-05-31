package com.boot.web.web;

import com.boot.web.defaultcontroller.DefaultController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: LiuHeYong
 * @create: 2019-05-24
 * @description: LoginController
 **/
@Controller
public class LoginController extends DefaultController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加⼊⼀个属性，⽤来在模板中读取
        map.addAttribute("host", "http://wenyixicodedog.com");
        // return模板⽂件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}
