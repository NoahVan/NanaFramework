package com.nana.demo.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class TestStaticInit {

    public static int a = 1;

    public static String s = "aaa";

    public static Object o = new Object();

    static {
        System.out.println("static block");
    }

    public static void test(){
        System.out.println("static method");
    }


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }

        ThreadLocalRandom current = ThreadLocalRandom.current();

        for (int i = 0; i < 10; i++) {
            System.out.println(current.nextInt(5));
        }

    }
}
