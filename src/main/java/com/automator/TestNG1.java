package com.automator;

import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

public class TestNG1 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @Test
    public void test1() {
        System.out.println("this is test case 1");
    }

    @Test(enabled = false)
    public void test2() {
        System.out.println("this is test case 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @Test
    public void assertEquals() {
        String a = "123";
        String b = "1233";
        Assert.assertEquals(a, b);

    }

    @Test
    public void testLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.baidu.com");
        driver.findElement(By.linkText("登录")).click();

        Thread.sleep(1000);
//        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();

//        driver.findElement(By.id("TANGRAM__PSP_4__closeBtn")).click();

    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("./1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.linkText("设置"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
//        element.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("搜索设置")));
        driver.findElement(By.linkText("搜索设置")).click();

        Thread.sleep(2000);
        WebElement sel = driver.findElement(By.xpath("//*[@id=\"nr\"]"));
        Select select = new Select(sel);
        select.selectByIndex(2);
    }

    @Test
    public void test5() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com");

//        driver.findElement(By.linkText("新闻")).click();
//
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("首页")));
//
//        System.out.println(driver.getTitle());

//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("新闻")));
//
//        Thread.sleep(1000);
//        Actions actions = new Actions(driver);
//        actions.contextClick(driver.findElement(By.linkText("新闻"))).build().perform();
//
//        Thread.sleep(1000);
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_8);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_ENTER);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.getElementById('kw').setAttribute('value', 'selenium')");

    }

    @Test
    public void phantomJS() {
        System.setProperty("phantomjs.binary.path", "/Users/lulu/Documents/selenium/phantomjs-2.1.1-macosx/bin/phantomjs");
        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test()
    public void yeahLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/lulu/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yeah.net/");

        driver.findElement(By.id("lbNormal")).click();

        Thread.sleep(3000);

        WebElement frame = driver.findElement(By.xpath(".//div[@class=\"loginUrs\"]/iframe"));
        driver.switchTo().frame(frame);

        //yonghuming
        WebElement username = driver.findElement(By.xpath(".//input[@placeholder=\"邮箱帐号或手机号码\"]"));
        username.sendKeys("xiaobai1315@yeah.net");

        //mima
        WebElement pwd = driver.findElement(By.xpath(".//input[@placeholder=\"输入密码\"]"));
        pwd.sendKeys("Abcd1234");

        //login
        driver.findElement(By.id("dologin")).click();

        driver.switchTo().defaultContent();

        //登录需要短信激活，这里手动输入短信
        Thread.sleep(30000);


        //点击写信
        driver.findElement(By.xpath("//div[@id=\"dvNavTop\"]/ul//span[text()=\"写 信\"]")).click();
        Thread.sleep(2000);

        //收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("xiaobai1315@yeah.net");

        //主题
        driver.findElement(By.xpath("//div[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("this is title");

        //附件
        driver.findElement(By.xpath(".//div[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("/Users/lulu/Desktop/background.png");

        //内容frame
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));

        driver.findElement(By.className("nui-scroll")).sendKeys("this is content");

        driver.switchTo().defaultContent();
        //发送
        driver.findElement(By.xpath(".//footer[@class=\"jp0\"]/div[1]/span[2]")).click();
    }

    @DataProvider(name = "data1")
    public Object[][] data() {

        return new Object[][]{
                {"http://192.168.0.1:4444", "chrome"},
                {"http://192.168.0.1:4444", "firefox"}
        };
    }

    @Test(dataProvider = "data1")
    public void gridTest(String url, String browser) throws MalformedURLException {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        if (browser == "chrome") {
//            capabilities = DesiredCapabilities.chrome();
//        }else if (browser == "firefox") {
//            capabilities = DesiredCapabilities.firefox();
//        }
//
//        WebDriver driver = new RemoteWebDriver(new URL(url), capabilities);
//        driver.get("http://www.baidu.com");
        System.out.println(url + " " + browser);

    }
}
