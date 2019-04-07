package com.nana.demo.service;

import com.nana.annotation.Service;

@Service
public class TestService {

    public String test1(String name){

        return name + " service";
    }
}
