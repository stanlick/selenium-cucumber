package com.example.demo.selenium.no.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By username = By.id("username");
    By password = By.id("password");
    By signInButton = By.xpath("/html/body/div/form/button");
    By pleaseSignIn = By.xpath("/html/body/div/form/h2");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Check that we're on the right page.
        if (!"Please sign in".equals(driver.findElement(pleaseSignIn).getText())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage typeUserName(String user) {
        driver.findElement(username).sendKeys(user);
        return this;
    }

    public LoginPage typePassword(String pass) {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public HomePage clickOnSignInButton() {
        // This is the only place that submits the login form and expects the
        // destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst
        // expecting a login failure.
        driver.findElement(signInButton).submit();

        // Return a new page object representing the destination. Should the login page
        // ever
        // go somewhere else (for example, a legal disclaimer) then changing the method
        // signature
        // for this method will mean that all tests that rely on this behaviour won't
        // compile.
        return new HomePage(driver);
    }

    // The login page allows the user to submit the login form knowing that an
    // invalid username and / or password were entered
    public LoginPage submitLoginExpectingFailure() {
        // This is the only place that submits the login form and expects the
        // destination to be the login page due to login failure.
        driver.findElement(signInButton).submit();

        // Return a new page object representing the destination. Should the user ever
        // be navigated to the home page after submiting a login with credentials
        // expected to fail login, the script will fail when it attempts to instantiate
        // the LoginPage PageObject.
        return new LoginPage(driver);
    }

    // Conceptually, the login page offers the user the service of being able to
    // "log into"
    // the application using a user name and password.
    public HomePage loginAs(String username, String password) {
        // The PageObject methods that enter username, password & submit login have
        // already defined and should not be repeated here.
        typeUserName(username);
        typePassword(password);
        return clickOnSignInButton();
    }

}