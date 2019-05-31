package com.boot.web.web;

import com.boot.commons.dto.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: LiuHeYong
 * @create: 2019-05-31
 * @description: 接收xml数据测试
 **/
@Controller
public class StudentController {

    @RequestMapping(value = "/student",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Student testXMLStudent(@RequestBody Student student) {
        return student;
    }

}
