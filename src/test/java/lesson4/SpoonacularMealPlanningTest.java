package lesson4;

import org.example.lesson4.dto.AddRequest;
import org.example.lesson4.dto.AddResponse;
import org.example.lesson4.dto.DeleteResponse;
import org.example.lesson4.dto.GetResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpoonacularMealPlanningTest extends AbstractTest{

    @Test
    void mealPlanShoppingListTest(){
        Specifications.initSpecification(Specifications.requestSpecMeal());
        given()
                .pathParam("start-date", "2022-12-21")
                .pathParam("end-date", "2022-12-30")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/{start-date}/{end-date}")
                .then();

        AddRequest req = new AddRequest("1 package baking powder", "Baking", true);
        AddResponse addResponse = given()
                .body(req)
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .extract()
                .response()
                .body().as(AddResponse.class);
        assertThat(addResponse.getName(), containsString("baking powder"));
        assertThat(addResponse.getAisle(), containsString("Baking"));
        String id = addResponse.getId().toString();

        GetResponse getResponse = given()
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then()
                .extract()
                .response()
                .body().as(GetResponse.class);
        assertThat(getResponse.getCost(), is(0.71));
        assertThat(getResponse.getAisles().get(0).getItems().get(0).getId().toString(), containsString(id));
        assertThat(getResponse.getAisles().get(0).getAisle(), containsString("Baking"));

        DeleteResponse deleteResponse = given()
                .pathParam("id", id)
                .when()
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .extract()
                .response()
                .body().as(DeleteResponse.class);
        assertThat(deleteResponse.getStatus(), containsString("success"));
    }
}