package tests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;



public class BaseTest {

    @BeforeClass
    public void setbaseURI() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
    }

    public void basicsget() {
        when().get("users?page=1").
        then().
                assertThat().
                statusCode(HttpStatus.SC_OK);

    }

}
