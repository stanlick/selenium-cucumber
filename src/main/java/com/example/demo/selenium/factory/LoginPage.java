package com.example.demo.selenium.factory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @CacheLookup @FindBy(how = How.ID, using = "username")
    WebElement username;
    @CacheLookup @FindBy(how = How.ID, using = "password")
    WebElement password;
    @CacheLookup @FindBy(how = How.XPATH, using = "/html/body/div/form/button")
    WebElement signInButton;
    @CacheLookup @FindBy(how = How.XPATH, using = "/html/body/div/form/h2")
    WebElement pleaseSignIn;
    @CacheLookup @FindBy(how = How.LINK_TEXT, using = "Forgot Password")
    WebElement forgotPasswordLink;

    @FindBy(how = How.TAG_NAME, using = "a")
    List<WebElement> allLinks;

    public LoginPage(WebDriver factoryDriver){
        this.driver=factoryDriver;
        PageFactory.initElements(driver, this);
        if (!"Please sign in".equals(pleaseSignIn.getText())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }


    public HomePage login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        signInButton.click();
        return new HomePage(driver);
    }

    public LoginPage loginInvalid() {
        signInButton.click();
        return new LoginPage(driver);
    }
}