package com.saucedemo.proj.step;
import com.saucedemo.proj.driver.SingletonDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    private WebDriver driver;
    private String url = "https://www.saucedemo.com/";
    @FindBy(xpath = "//*[@class='error-message-container error']")
    private List<WebElement> resultMessages;
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    //start find by stateTransitionTests page
    @FindBy(xpath = "//*[@class='inventory_list']")
    private List<WebElement> inventoryList;
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;
    @FindBy(id = "checkout")
    private WebElement checkoutCart;
    @FindBy(id = "first-name")
    private WebElement enterName;
    @FindBy(id = "last-name")
    private WebElement enterLastName;
    @FindBy(id = "postal-code")
    private WebElement enterZipCode;
    @FindBy(id = "continue")
    private WebElement enterContinue;
    @FindBy(id = "finish")
    private WebElement clickFinish;
    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutContainer;
    //end find by stateTransitionTests page


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkResultMessages(String result) {
        if (!resultMessages.isEmpty()) {
            WebElement resultMessage = resultMessages.get(0);
            String actualResult = resultMessage.getText();
            assertTrue(actualResult.contains(result));
        } else {
            System.out.println("Тест");
            if (!"".equals(result) && !isOnInventoryPage()) {
                driver.findElement(By.id("user-name")).clear();
                driver.findElement(By.id("password")).clear();
            }
        }
    }

    public void enterUserName(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void openLoginPage() {
        driver.get(url);
    }

    private boolean isOnInventoryPage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("inventory.html");
    }
    public void enterInventoryList() {
        WebElement firstInventoryItem = inventoryList.get(0);
        firstInventoryItem.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public void clickProceedTo() {
        checkoutCart.click();
    }

    public void enterCheckoutName(String firstName) {
        if (enterLastName != null) {
            enterLastName.sendKeys(firstName);

            String enteredValue = enterLastName.getAttribute("Bogdan");
            if (enteredValue != null && enteredValue.equals(firstName)) {
                System.out.println("The data in the firstName input field is correct.");
            } else {
                System.out.println("The data in the firstName input field is not correct. This is a bug");
            }
        } else {
            System.out.println("The element 'enterLastName' was not found.");
        }
    }

    public void enterLastName(String lastName) {
        if (enterLastName != null) {
        enterLastName.sendKeys(lastName);
        String enteredValue = enterLastName.getAttribute("Mykhailov");
        if (enteredValue != null && enteredValue.equals(lastName)) {
            System.out.println("The data in the lastName input field is correct.");
        } else {
            System.out.println("The data in the lastName input field is not correct. This is a bug");
        }
        } else {
        System.out.println("The element 'enterLastName' was not found.");
    }
      }
    public void enterZip(String zipCode) {
        if (enterZipCode != null) {
            enterZipCode.sendKeys(zipCode);
            String enteredValue = enterLastName.getAttribute("21012");
            if (enteredValue != null && enteredValue.equals(zipCode)) {
                System.out.println("The data in the zipCode input field is correct.");
            } else {
                System.out.println("The data in the zipCode input field is not correct. This is a bug");
            }
        } else {
            System.out.println("The element 'enterZipCode' was not found.");
        }
    }
    public void enterContinue() {
        enterContinue.click();
    }
    public void clickFinishButton() {
        clickFinish.click();
    }
    public void checkoutContainerFinish() {
        Assert.assertTrue(checkoutContainer.isDisplayed());
    }

    }

