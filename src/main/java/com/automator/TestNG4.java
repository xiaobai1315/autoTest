package com.automator;

import org.testng.annotations.Test;

public class TestNG4 {
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("test1 + " + Thread.currentThread().getId());
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("test2 + " + Thread.currentThread().getId());
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("test3 + " + Thread.currentThread().getId());
    }
}
