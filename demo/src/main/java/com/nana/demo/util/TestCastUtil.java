package com.nana.demo.util;

import com.nana.HelperLoader;
import com.nana.annotation.Inject;
import com.nana.demo.service.TestService;
import com.nana.helper.BeanHelper;

import java.util.concurrent.FutureTask;

public class TestCastUtil {

    public static void main(String[] args) {

//        HelperLoader.init();
//
//        String name = BeanHelper.getBean(TestService.class).test1("111");
//        System.out.println(name);
        TestStaticInit.test();
    }



}
