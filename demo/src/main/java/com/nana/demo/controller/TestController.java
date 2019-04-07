package com.nana.demo.controller;

import com.nana.annotation.Action;
import com.nana.annotation.Controller;
import com.nana.annotation.Inject;
import com.nana.demo.service.TestService;

@Controller
public class TestController {

    @Inject
    private TestService testService;

    @Action("post:test1")
    public String test1(String name){
        return testService.test1(name);
    }
}
