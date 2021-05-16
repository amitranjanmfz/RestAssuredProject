package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtils {

    public static Response getRequest(String url)
    {
        Response response = RestAssured.given().
                when().
                get(url).
                then().extract().response();

        return response;
    }

    public static Response postRequest(String url,String payload)
    {
        Response response = RestAssured.given().
                when().body(payload).
                post(url).then().extract().response();

        return response;
    }

    public static Response putRequest(String url,String payload)
    {
        Response response = RestAssured.given().
                when().body(payload).
                put(url).then().extract().response();

        return response;
    }
}
