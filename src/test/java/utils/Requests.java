package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Requests {

    private static RequestSpecification getReqSpec(){
        return RestAssured.given().contentType("application/json").urlEncodingEnabled(false);
    }

    public static Response get(String uri){
        Response response = getReqSpec().when().log().all().get(uri.trim());
        response.getBody().prettyPrint();

        return response;
    }


}
