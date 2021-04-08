package tests;

import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.DummyPayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Esra_API_Equifax {
    @Test
    public void getUsers() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
        given().log().all().
                when().get("/employee/").
                then().log().all().statusCode(200).body("status",equalTo("success"));

    }
    @Test
    public void getSingleUser() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        String response= given().log().all().
                when().get("/employee/1").
                then().log().all().statusCode(200).extract().asString();

        JsonPath js = new JsonPath(response);
        String actualName=js.getString("data.employee_name");
        String expectedName="Tiger Nixon";
        Assert.assertEquals(actualName,expectedName,"Failure");


    }
    @Test
    public void postUser() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        given().log().all().body("{\n" +
                "   \"name\":\"test1\",\n" +
                "   \"salary\":\"124\",\n" +
                "   \"age\":\"22\"\n" +
                "}").
                when().post("/create").
                then().log().all().statusCode(200);
    }
    @Test
    public void postUserPojo() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        given().log().all().body(DummyPayload.addUser()).
                when().post("/create").
                then().log().all().statusCode(200);
    }
    @Test
    public void updateUser() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        given().log().all().body("{\n" +
                "   \"name\":\"test1\",\n" +
                "   \"salary\":\"1233\",\n" +
                "   \"age\":\"25\"\n" +
                "}").
                when().put("/update/21").
                then().log().all().statusCode(200);
    }
    @Test
    public void deleteUser() {
    RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        given().log().all().
                when().delete("/delete/2").
                then().log().all();
    }

}
