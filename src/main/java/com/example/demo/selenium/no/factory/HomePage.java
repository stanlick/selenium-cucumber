package com.example.demo.selenium.no.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By homePageLogOffButton = By.xpath("//*[@id='navbar']/ul[2]/li/p/a");

	

	public HomePage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        if (!driver.findElement(homePageLogOffButton).getText().contains("Log off")) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the home page");
        }
	}

}
