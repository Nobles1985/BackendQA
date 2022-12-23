package lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public class Specifications extends AbstractTest{

    public static RequestSpecification requestSpecCuisine(){
        return new RequestSpecBuilder()
                .addQueryParam("language", "en")
                .setContentType("application/x-www-form-urlencoded")
                .build();
    }
    public static RequestSpecification requestSpecMeal(){
        return new RequestSpecBuilder()
                .addQueryParam("hash", getHash())
                .addPathParam("username", getUsername())
                .build();
    }

    public static void initSpecification(RequestSpecification request){
        RestAssured.requestSpecification = request;
    }
}