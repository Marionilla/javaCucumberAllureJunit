package com.saucedemo.proj.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SingletonDriver {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    private SingletonDriver() {

    }

    public static synchronized WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
        }
        return driverThreadLocal.get();
    }



    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}