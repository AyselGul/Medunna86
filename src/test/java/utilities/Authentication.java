package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.spec;

public class Authentication {


    public static String generateToken(){


        //Set path params
        // api/authenticate

        spec.pathParams("first", "api", "second", "authenticate");



        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("username", "teamadmin86");
        expectedData.put("password", "teamadmin86");
        expectedData.put("rememberme", true);


        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();

        JsonPath json = response.jsonPath();

        return json.getString("id_token");
    }



}
