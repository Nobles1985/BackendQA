package lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.example.lesson4.dto.AddResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpoonacularMealPlanningTest extends AbstractTest{

    private static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() {
        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("hash", getHash())
                .addPathParam("username", getUsername())
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

        File request = new File("src/main/resources/request.json");

        AddResponse response = given()
                .body(request)
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .extract()
                .response()
                .body().as(AddResponse.class);
        assertThat(response.getName(), containsString("baking powder"));
        assertThat(response.getAisle(), containsString("Baking"));
        String id = response.getId().toString();

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