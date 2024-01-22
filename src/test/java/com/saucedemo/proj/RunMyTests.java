package com.saucedemo.proj;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/saucedemo/proj/resources/test.feature", "src/test/java/com/saucedemo/proj/resources/stateTransitionTesting.feature"},
        glue = "com.saucedemo.proj.tests",
        plugin = {"pretty", "html:target/cucumber-reports"}

)
public class RunMyTests {

}
