package com.automator;

import org.testng.annotations.Test;

public class TestNG5 {
    @Test
    public void test31() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("test51 + " + Thread.currentThread().getId());
    }
}
