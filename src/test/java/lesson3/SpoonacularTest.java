package lesson3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


public class SpoonacularTest extends AbstractTest{

    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    //Spoonacular Recipe search module
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
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    //Spoonacular Classify Cuisine module

    @Test
    void classifyClamsWithSpanishSausage(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Clams With Spanish Sausage")
                .formParam("ingredientList", "potato\nfish")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyApplePieTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Apple Pie, Vermont Style")
                .formParam("ingredientList", "apple")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyEggSaladTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Egg Salad Sandwiches With Tarragon")
                .formParam("ingredientList", "egg\nblack pepper\nmayonnaise")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyCrabSaladTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Crab Salad Stuffed Pita Pockets")
                .formParam("ingredientList", "apple\npita breads\nwatercress")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifySausageAndPepperoniStromboliTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Sausage & Pepperoni Stromboli")
                .formParam("ingredientList", "mozzarella cheese\nbacon\npepperoni")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyPotatoSoupTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Loaded Baked Potato Soup")
                .formParam("ingredientList", "bacon\nmilk\nchopped onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyRamenTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Creamy Ramen Soup")
                .formParam("ingredientList", "coconut oil\ncloves garlic\nyellow onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyVeganDirtyChaiPuddingTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Vegan Dirty Chai Pudding")
                .formParam("ingredientList", "avocados\nvanilla\nginger")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyMuesliCookiesTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Muesli Cookies")
                .formParam("ingredientList", "muesli\negg")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void classifyBLTPizzaTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "BLT Pizza")
                .formParam("ingredientList", "bacon\nmozzarella cheese\ntomato")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    //Spoonacular Meal Planning module

    String id;

    @Test
    void mealPlanShoppingListTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .pathParam("username", getUsername())
                .pathParam("start-date", "2022-12-21")
                .pathParam("end-date", "2022-12-30")
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/{start-date}/{end-date}")
                .then()
                .statusCode(200);

        id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
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
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .pathParam("username", getUsername())
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .pathParam("username", getUsername())
                .pathParam("id", id)
                .when()
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .statusCode(200);
    }
}