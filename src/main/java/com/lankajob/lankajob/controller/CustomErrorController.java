package com.lankajob.lankajob.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String notFound(){
        return "404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
