package com.automator;

import com.object.Search;
import com.page.LoginView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG3 {

    @DataProvider(name = "data")
    public Object[][] data() {

        return new Object[][]{
                {"xiaobai", 20},
                {"xiaohong", 21},
                {"xiaohei", 22}
        };
    }

    @Test(dataProvider = "data")
    public void test1(String name, int age) {

        System.out.println("name = " + name + " ,age = " + age);
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        Search.search(driver, "selenium");
        Assert.assertEquals("", "");
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("test3 + " + Thread.currentThread().getId());
    }
}
