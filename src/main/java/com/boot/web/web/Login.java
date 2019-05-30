package com.boot.web.web;

import com.boot.web.defaultcontroller.DefaultController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: LiuHeYong
 * @create: 2019-05-24
 * @description:
 **/
@Controller
public class Login extends DefaultController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

}
