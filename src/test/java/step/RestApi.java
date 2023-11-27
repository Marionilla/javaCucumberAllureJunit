package step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class RestApi {



public class ExampleAPITest {

  //  @Test
    public void testGetRequestToWebsite() {
        // Встановлення базового URL
        RestAssured.baseURI = "https://www.saucedemo.com/";

        // Виконання GET-запиту
        Response response = RestAssured.get("/api/resource");

        // Перевірка статус-коду
        response.then().statusCode(200);

        // Перевірка тіла відповіді
        response.then().body("name", equalTo("standard_user"));
    }
}
}