package com.saucedemo.proj.tests;
import com.saucedemo.proj.driver.SingletonDriver;
import com.saucedemo.proj.step.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;

public class LoginTests {
    private LoginPage loginPage;
    private WebDriver driver;

  public LoginTests() {

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

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.openLoginPage();
    }
    @When("User enters {string} and password {string}")
    public void userEntersAndPassword(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }
    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }
    @Then("User should see {string}")
    public void userShouldSee(String result) {
        loginPage.checkResultMessages(result);
    }
}
