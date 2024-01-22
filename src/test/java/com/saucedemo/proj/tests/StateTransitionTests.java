package com.saucedemo.proj.tests;

import com.saucedemo.proj.config.YourPropertiesReader;

import com.saucedemo.proj.driver.SingletonDriver;
import com.saucedemo.proj.step.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StateTransitionTests {
private YourPropertiesReader yourPropertiesReader;
private WebDriver driver;
    private LoginPage loginPage;
    String userField;
    String passwordField;
public StateTransitionTests() {

}

    @Before
    public void setUp() {
        driver = SingletonDriver.getDriver();
         loginPage = new LoginPage(driver);
        System.out.format("Thread ID - %2d\n", Thread.currentThread().getId());
    }
    @After
    public void tearDown() {
        SingletonDriver.closeDriver();
    }

    @Given("I am on the saucedemo site")
    public void iAmOnSaucedemoSite() {
     yourPropertiesReader = YourPropertiesReader.getInstance();
      String propertyValue = yourPropertiesReader.getProperty("url");
      driver.get(propertyValue);
     // Assert.assertTrue(propertyValue.contains("saucedemo.com"));
    }
    @When("I enters correct {string} and {string}")
    public void iEntersCorrectData(String username, String password) {
        userField = username;
        passwordField = password;
        loginPage.enterUserName(userField);
        loginPage.enterPassword(passwordField);

    }
    @And("I clicks the login button")
    public void iClicksTheLoginButton() {
        loginPage.clickLoginButton();

    }
    @And("I go to the inventory list")
    public void iGoToTheInventoryList() {
        loginPage.enterInventoryList();
    }
    @And("I go to the cart")
    public void iGoToTheCart() {
        loginPage.clickShoppingCart();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        loginPage.clickProceedTo();
    }

    @And("I fill in the first name as {string}")
    public void iFillInFirstName(String firstName) {
      loginPage.enterCheckoutName(firstName);
    }

    @And("I fill in the last name as {string}")
    public void iFillInLastName(String lastName) {
       loginPage.enterLastName(lastName);
    }

    @And("I fill in the zip code as {string}")
    public void iFillInZipCode(String zipCode) {
        loginPage.enterZip(zipCode);
    }
    @And("I continue")
    public void iContinue() {
       loginPage.enterContinue();
    }
    @And("I finish")
    public void iFinish() {
        loginPage.clickFinishButton();
    }

    @Then("I should see a confirmation page")
    public void i_should_see_confirmation_page() {
      loginPage.checkoutContainerFinish();
    }

}
