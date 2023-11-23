package step;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class FirstScenarioPage {

private WebDriver driver;
    private YourPropertiesReader propertiesReader;
@Before
public void setUp() {
    this.driver = DriverFactory.getDriver();
    this.propertiesReader = new YourPropertiesReader("src/test/resources/test.properties");
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

 @Given("User is on the login page")
    public void userIsOnLoginPage() {
     driver.get(propertiesReader.getUrl());
 }
 @When("User enters {string} and password {string}")
public void userEntersData(String username, String password) {
WebElement usernameInput = driver.findElement(By.id("user-name"));
WebElement passwordInput = driver.findElement(By.id("password"));

usernameInput.sendKeys(username);
passwordInput.sendKeys(password);
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//     wait.until(ExpectedConditions.visibilityOf(usernameInput));
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     //WebElement userNameElement = new WebDriverWait(driver, Duration.ofSeconds(10))
          //   .until(ExpectedConditions.visibilityOf(driver.findElement(usernameInput)));
 }
 @And("User clicks the login button")
    public void userClicksTheLoginButton() {
WebElement loginButton = driver.findElement(By.id("login-button"));
loginButton.click();
    }
    @Then("User should see {string}")
    public void userShouldSee(String result) {
        By locator = By.xpath("//*[@class='error-message-container error']");
        List<WebElement> resultMessages = driver.findElements(locator);

        if (!resultMessages.isEmpty()) {
            WebElement resultMessage = resultMessages.get(0);
//            assertEquals(result, resultMessage);
            String actualResult = resultMessage.getText();
            assertTrue(actualResult.contains(result));
        } else {
            System.out.println("Тест");
            if (!"".equals(result) && !isOnInventoryPage()) {
                driver.findElement(By.id("user-name")).clear();
                driver.findElement(By.id("password")).clear();
            }
//            assertTrue("Test passed: The page contains 'inventory.html'", true);
//            String currentUrl = driver.getCurrentUrl();
//            if (currentUrl.contains("inventory.html") && result.equals("inventory.html")) {
//                assertTrue("Test passed: The page contains 'inventory.html'", true);
//            } else {
//                System.out.println("Помилка: Неочікуваний результат для заданих умов");
//            }
        }
//        driver.findElement(By.id("user-name")).clear();
//        driver.findElement(By.id("password")).clear();
    }
    private boolean isOnInventoryPage() {
        // Додайте код, який перевіряє, чи ви на іншій сторінці, наприклад, перевіряючи URL
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("inventory.html");
    }
}
