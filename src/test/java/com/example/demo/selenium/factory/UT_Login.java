package com.example.demo.selenium.factory;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class UT_Login {

    WebDriver driver;



    @After
    public void afterEach(){
        driver.quit();
    }


    @Test
    public void testValidLogin(){
        driver = BrowserFactory.startBrowser("chrome", "https://sitewords.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        HomePage pageReturned = loginPage.login("ziegler","password");
        assertThat(pageReturned, IsInstanceOf.instanceOf(HomePage.class));
    }

    
    @Test
    public void testInvalidLogin(){
        driver = BrowserFactory.startBrowser("chrome", "https://sitewords.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        LoginPage pageReturned = loginPage.loginInvalid();
        assertThat(pageReturned, IsInstanceOf.instanceOf(LoginPage.class));
    }

}