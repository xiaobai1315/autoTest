package com.automator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG2 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("test1");
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("test2");
        Thread.sleep(5000);
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("test3");
        Thread.sleep(5000);
    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("test4");
        Thread.sleep(5000);
    }

    @Test
    public void test5() throws InterruptedException {
        System.out.println("test5");
        Thread.sleep(5000);
    }

    @Test
    public void test6() throws InterruptedException {
        System.out.println("test6");
        Thread.sleep(5000);
    }

    @BeforeGroups(groups = "group1")
    public void beforeGroup1() {
        System.out.println("before group1");
    }

    @BeforeGroups(groups = "group2")
    public void beforeGroup2() {
        System.out.println("before group2");
    }
}
