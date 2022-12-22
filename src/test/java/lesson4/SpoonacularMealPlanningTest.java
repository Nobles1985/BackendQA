package lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularMealPlanningTest extends AbstractTest{

    private static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() {
        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", getApiKey())
                .addQueryParam("hash", getHash())
                .addPathParam("username", getUsername())
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpecification;
    }

    @Test
    void mealPlanShoppingListTest(){
        given()
                .pathParam("start-date", "2022-12-21")
                .pathParam("end-date", "2022-12-30")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/{start-date}/{end-date}")
                .then();

        String id = given()
                .body("{\n" +
                        "   \"item\": \"1 package baking powder\",\n" +
                        "   \"aisle\": \"Baking\",\n" +
                        "   \"parse\": true\n" +
                        "}")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then();

        given()
                .pathParam("id", id)
                .when()
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/{id}")
                .then();
    }
}