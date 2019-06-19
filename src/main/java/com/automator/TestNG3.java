package com.automator;

import com.object.Search;
import com.page.LoginView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG3 {

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        Search.search(driver, "selenium");
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }
}
