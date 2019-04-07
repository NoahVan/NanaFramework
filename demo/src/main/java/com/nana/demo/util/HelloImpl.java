package com.nana.demo.util;

public class HelloImpl implements Hello {
    @Override
    public void say(String s) {
        System.out.println("say : " + s);
    }
}
