package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Esra_API_Excercise {
    @Test
    public void getUsers() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
        given().log().all().
                when().get("/employee/").
                then().log().all().statusCode(200);
    }
    @Test
    public void postUser() {

        RestAssured.baseURI = "";
        given().log().all().body("").
                when().post("").
                then().log().all().statusCode(200);
    }
    @Test
    public void updateUser() {

        RestAssured.baseURI = "";
        given().log().all().body("").
                when().put("").
                then().log().all().statusCode(200);
    }
    @Test
    public void deleteUser() {
    RestAssured.baseURI = "";
        given().log().all().
                when().delete("").
                then().log().all();
    }

}
