package com.example.demo.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
    @CacheLookup @FindBy(how = How.XPATH, using = "//*[@id='navbar']/ul[2]/li/p/a")                                            
    WebElement homePageLogOffButton;

	public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // Check that we're on the right page.
        if (!homePageLogOffButton.getText().contains("Log off")) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the home page");
        }
	}

}
