package com.object;

import com.page.LoginView;
import org.openqa.selenium.WebDriver;

public class Search {
    public static void search(WebDriver driver, String msg) {
        driver.findElement(LoginView.searchView).sendKeys(msg);
        driver.findElement(LoginView.searchButton).click();
    }
}
