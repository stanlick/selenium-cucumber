package com.example.demo.selenium.no.factory;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UT_Login {

    WebDriver driver;

    @Before
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/stanlick/Dropbox/home/selenium/webDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sitewords.herokuapp.com/login");
    }

    @After
    public void afterEach(){
        driver.quit();
    }


    @Test
    public void testValidLogin(){
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginAs("ziegler","password");
        assertThat(homePage, IsInstanceOf.instanceOf(HomePage.class));
    }

    @Test
    public void testInvalidLogin() throws Exception{
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        LoginPage login = loginPage.submitLoginExpectingFailure();

    }
}