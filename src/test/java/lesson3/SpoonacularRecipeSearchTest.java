package lesson3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class SpoonacularRecipeSearchTest extends AbstractTest{

    @Test
    void saladRecipeSearchTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "salad")
                .queryParam("cuisine", "korean")
                .queryParam("diet", "paleo")
                .queryParam("equipment", "bowl")
                .queryParam("type", "salad")
                .queryParam("instructionsRequired", true)
                .queryParam("maxReadyTime", 35)
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void pizzaRecipeSearchTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .queryParam("excludeCuisine", "american")
                .queryParam("diet", "whole30")
                .queryParam("includeIngredients", "cheese,tomatoes")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 5)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void pastaRecipeSearchTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("instructionsRequired", true)
                .queryParam("maxReadyTime", 25)
                .queryParam("minCarbs", 30)
                .queryParam("maxCarbs", 75)
                .queryParam("minCalories", 200)
                .queryParam("maxCalories", 400)
                .queryParam("number", 5)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void searchKoreanVeganRecipesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "korean")
                .queryParam("diet", "vegan")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 7)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void searchForRecipesWithChickenAndBeefTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "chicken,beef")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 5)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void dessertRecipeSearchTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "dessert")
                .queryParam("instructionsRequired", true)
                .queryParam("excludeIngredients", "sugar")
                .queryParam("maxReadyTime", 50)
                .queryParam("number", 7)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void americanPieRecipeTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pie")
                .queryParam("cuisine", "american")
                .queryParam("type", "dessert")
                .queryParam("instructionsRequired", true)
                .queryParam("sort", "popularity")
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void vegetarianDishesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "vegetarian")
                .queryParam("sort", "popularity")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void europeanBreakfastRecipeTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "european")
                .queryParam("type", "breakfast")
                .queryParam("sort", "popularity")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void sortingDishesByUsefulnessTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "soup")
                .queryParam("sort", "healthiness")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void popularDishesWithCheeseTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "cheese")
                .queryParam("sort", "popularity")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void randomDishesOfFranceAndLatinAmericaTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "main course")
                .queryParam("cuisine", "french,latin american")
                .queryParam("sort", "random")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void sortMealsByCaloriesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "main course")
                .queryParam("minCalories", 10)
                .queryParam("maxCalories", 700)
                .queryParam("sort", "calories")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void sortingDishesByPriceTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "dessert")
                .queryParam("sort", "price")
                .queryParam("number", 10)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void findRecipesWithPotatoesAndFishTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "european")
                .queryParam("includeIngredients", "potato,fish")
                .queryParam("sort", "popularity")
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void popularJapaneseRecipesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "japanese")
                .queryParam("sort", "popularity")
                .queryParam("type", "soup")
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void popularBritishDessertsTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "british")
                .queryParam("sort", "popularity")
                .queryParam("type", "dessert")
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void fishSaladRecipesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "salad")
                .queryParam("includeIngredients", "fish")
                .queryParam("type", "salad")
                .queryParam("number", 7)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void mexicanChickenTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "mexican")
                .queryParam("includeIngredients", "chicken")
                .queryParam("type", "side dish")
                .queryParam("number", 5)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void indianVegetarianDishesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "indian")
                .queryParam("type", "main course")
                .queryParam("diet", "vegetarian")
                .queryParam("sort", "time")
                .queryParam("number", 5)
                .log().all()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
}