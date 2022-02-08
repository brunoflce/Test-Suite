package tests;

import org.testng.annotations.Test;
import tests.BaseTest;

import static utils.ExtentTestManager.reporterLog;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class MethodsTest extends BaseTest {

    @Test(testName = "GET Method", description = "Tests the GET Method from GoRest.in")
    public void testGet() {
        reporterLog("Running basics test");
        basicsget();
        reporterLog("Running specific test");
        when().
                get("users?page=1").
        then().
                assertThat().
                body(matchesJsonSchemaInClasspath("gorest.json")).
//                This might change overtime, please check if the data is correct
                body("[0].gender", equalTo("male")).
                body("[0].name", equalTo("Bhagvan Kaul"));
        reporterLog("Exiting");
    }

}
