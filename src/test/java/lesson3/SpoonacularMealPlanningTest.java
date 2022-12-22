package lesson3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class SpoonacularMealPlanningTest extends AbstractTest{

    @Test
    void mealPlanShoppingListTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .log().all()
                .pathParam("username", getUsername())
                .pathParam("start-date", "2022-12-21")
                .pathParam("end-date", "2022-12-30")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/{start-date}/{end-date}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

        String id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .log().all()
                .pathParam("username", getUsername())
                .body("{\n" +
                        "   \"item\": \"1 package baking powder\",\n" +
                        "   \"aisle\": \"Baking\",\n" +
                        "   \"parse\": true\n" +
                        "}")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .log().all()
                .pathParam("username", getUsername())
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .log().all()
                .pathParam("username", getUsername())
                .pathParam("id", id)
                .when()
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
}