package com.example.demo.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FizzBuzzStepdefs {

    private FizzBuzz game;
    private String result;

    @Given("^create a FizzBuzz game$")
    public void createAFizzBuzzGame() {
        this.game = new FizzBuzz();
    }

    @When("^I play with number (\\d+)$")
    public void iPlayWithNumber(int number) {
        this.result = game.play(number);
    }

    @Then("^The result is \"([^\"]*)\"$")
    public void theResultIsFizz(String resultString) {
        Assert.assertEquals(result, resultString);
    }
}
