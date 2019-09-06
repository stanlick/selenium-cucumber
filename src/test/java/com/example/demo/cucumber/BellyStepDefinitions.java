package com.example.demo.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BellyStepDefinitions {

    @Given("^I have (\\d+) cukes in my belly$")
    public void i_have_cukes_in_my_belly(int n) throws Exception {
        System.out.println(String.format("I have %d cukes in my fat ass belly", n));
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Exception {

    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Exception {

    }

}