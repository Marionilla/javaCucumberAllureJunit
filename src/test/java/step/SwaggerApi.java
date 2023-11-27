package step;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class SwaggerApi {

    private Response response;

    @Given("the user has access to the Petstore API")
    public void userHasAccessToPetstoreAPI() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("the user sends a GET request to retrieve information about the user with identifier {string}")
    public void userSendsGetRequest(String userName) {
        response = given()
                .log().all() // логування всіх деталей запиту
                .when()
                .get("/user/" + userName);
    }

    @Then("the server should return status code {int}")
    public void serverShouldReturnStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response should contain the username {string}")
    public void responseShouldContainUserName(String expectedUserName) {
        String actualUserName = response.jsonPath().getString("username");
        assertEquals(expectedUserName, actualUserName);
    }
}
