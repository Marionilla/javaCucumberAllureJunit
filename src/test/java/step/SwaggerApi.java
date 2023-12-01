package step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SwaggerApi {
    private String userId;
    private Response response;
    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = DriverFactory.getDriver();
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
   @Given("the user has access to the API")
    public void userHasAccessToAPI() {

       RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("the user sends a POST request to create a new user with the name {string}")
    public void userSendsPostRequest(String userName) {
//String requestBody = "{ \"id\": 0, \"username\": \"" + userName + "\", \"firstName\": \"maryna\"," +
//        "\"lastName\": \"mykhailova\", \"email\": \"test@gmail.com\", \"password\": \"111\", " +
//        "\"phone\": \"1234567890\", \"userStatus\": 0 }";
     //   System.out.println("Request Body: " + requestBody);


        given()
                .contentType("application/json")
                .body("{ \"id\": 0, \"username\": \"" + userName + "\", \"firstName\": \"maryna\"," +
        "\"lastName\": \"mykhailova\", \"email\": \"test@gmail.com\", \"password\": \"111\", " +
        "\"phone\": \"1234567890\", \"userStatus\": 0 }")
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200);
//
//
//        response = RestAssured.given()
//                .log().all()
//                .contentType("application/json")
//                //.body(requestBody)
//                .when()
//                .post("/user/createWithList");
//        response.prettyPrint();
//        assertEquals(200, response.getStatusCode());

//        // Assume that the API returns the user ID in the response
//        userId = response.getBody().asString();
    }
    @Then("the response should contain the username {string}")
    public void andTheResponseShouldContainUsername(String expectedName) {
         response = RestAssured.given()
                .when()
                .get("/user/" + expectedName);

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains(expectedName));
    }
    @When("the user sends a PUT request to update the information about the user {string} with the new name {string}")
    public void userUpdatesUser(String oldUserName, String newUserName) {
        response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body("{ \"username\": \"" + newUserName + "\", \"id\": 0, \"email\": \"test@gmail.com\", \"phone\": \"1234567890\", \"userStatus\": 0 }")
                .when()
                .put("/user/" + oldUserName);
        assertEquals(200, response.getStatusCode());
    }
    @Then("the response should contain the updated username {string}")
    public void andTheResponseShouldContainUpdatedUsername(String updatedName) {
        response = RestAssured.given()
                .when()
                .get("/user/" + updatedName);

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains(updatedName));
    }
    @When("the user sends a DELETE request to delete the user with the name {string}")
    public void userDeletesUser(String userName) {
        response = RestAssured.given()
                .log().all()
                .when()
                .delete("/user/" + userName);
        assertEquals(204, response.getStatusCode());
    }
    @Then("the response should not contain the username {string}")
    public void andTheResponseShouldNotContainUsername(String deletedName) {
         response = RestAssured.given()
                .when()
                .get("/user/" + deletedName);

        assertEquals(404, response.getStatusCode());
        assertFalse(response.getBody().asString().contains(deletedName));
    }


}
