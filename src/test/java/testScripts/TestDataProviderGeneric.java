package testScripts;

import dataprovider.DataProviderArguments;
import dataprovider.GenericDataProvider;
import helpers.JsonCreator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utils.RestAssuredUtils;

import java.util.Map;

public class TestDataProviderGeneric {

@Test(dataProvider = "GenericDataProvider", dataProviderClass = GenericDataProvider.class,testName = "news")
@DataProviderArguments("file=./src/test/resources/NewsAssessmentCreate.xls")
public static void testDataProvider(Map dataproviderArgs)
    {
        System.out.println("Test case");

        JSONObject payload = JsonCreator.parse(JsonCreator.jsonReader("test.json"),
                JsonCreator.getJsonRequestKeySet(dataproviderArgs),JsonCreator.getJsonRequestValueSet(dataproviderArgs));
        System.out.println(payload.toString(4));

        System.out.println("Title: "+dataproviderArgs.get("Title").toString());

        Response response = RestAssured.given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().extract().response();

        System.out.println(response.getBody().asString().toString());
//                assertThat().
//                body("MRData.CircuitTable.Circuits.circuitId", Matchers.hasSize(20));

        Response response2 = RestAssuredUtils.postRequest("http://restapi.demoqa.com/customer/register","{\"FirstName\" : \"Rohit\"," +
                "\"LastName\" : \"Nagdeo\"," +
                "\"UserName\" : \"value\"," +
                "\"Password\" : \"value\"," +
                "\"Email\"        : \"Value\"" +
                "\n" +
                " }");
//                RestAssured.given().
//                when().body("{\"FirstName\" : \"Rohit\"," +
//                "\"LastName\" : \"Nagdeo\"," +
//                "\"UserName\" : \"value\"," +
//                "\"Password\" : \"value\"," +
//                "\"Email\"        : \"Value\"" +
//                "\n" +
//                " }").
//                post("http://restapi.demoqa.com/customer/register").then().extract().response();

        System.out.println(response2.getBody().asString().toString());
    }


}
