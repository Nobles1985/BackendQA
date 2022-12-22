package lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularRecipeSearchTest extends AbstractTest{

    @Test
    void saladRecipeSearchTest(){
        given()
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
                .then();
    }

    @Test
    void pizzaRecipeSearchTest(){
        given()
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .queryParam("excludeCuisine", "american")
                .queryParam("diet", "whole30")
                .queryParam("includeIngredients", "cheese,tomatoes")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void pastaRecipeSearchTest(){
        given()
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
                .then();
    }

    @Test
    void searchKoreanVeganRecipesTest(){
        given()
                .queryParam("cuisine", "korean")
                .queryParam("diet", "vegan")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 7)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void searchForRecipesWithChickenAndBeefTest(){
        given()
                .queryParam("includeIngredients", "chicken,beef")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void dessertRecipeSearchTest(){
        given()
                .queryParam("type", "dessert")
                .queryParam("instructionsRequired", true)
                .queryParam("excludeIngredients", "sugar")
                .queryParam("maxReadyTime", 50)
                .queryParam("number", 7)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void americanPieRecipeTest(){
        given()
                .queryParam("query", "pie")
                .queryParam("cuisine", "american")
                .queryParam("type", "dessert")
                .queryParam("instructionsRequired", true)
                .queryParam("sort", "popularity")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void vegetarianDishesTest(){
        given()
                .queryParam("diet", "vegetarian")
                .queryParam("sort", "popularity")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void europeanBreakfastRecipeTest(){
        given()
                .queryParam("cuisine", "european")
                .queryParam("type", "breakfast")
                .queryParam("sort", "popularity")
                .queryParam("instructionsRequired", true)
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void sortingDishesByUsefulnessTest(){
        given()
                .queryParam("type", "soup")
                .queryParam("sort", "healthiness")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void popularDishesWithCheeseTest(){
        given()
                .queryParam("includeIngredients", "cheese")
                .queryParam("sort", "popularity")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void randomDishesOfFranceAndLatinAmericaTest(){
        given()
                .queryParam("query", "main course")
                .queryParam("cuisine", "french,latin american")
                .queryParam("sort", "random")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void sortMealsByCaloriesTest(){
        given()
                .queryParam("type", "main course")
                .queryParam("minCalories", 10)
                .queryParam("maxCalories", 700)
                .queryParam("sort", "calories")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void sortingDishesByPriceTest(){
        given()
                .queryParam("type", "dessert")
                .queryParam("sort", "price")
                .queryParam("number", 10)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void findRecipesWithPotatoesAndFishTest(){
        given()
                .queryParam("cuisine", "european")
                .queryParam("includeIngredients", "potato,fish")
                .queryParam("sort", "popularity")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void popularJapaneseRecipesTest(){
        given()
                .queryParam("cuisine", "japanese")
                .queryParam("sort", "popularity")
                .queryParam("type", "soup")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void popularBritishDessertsTest(){
        given()
                .queryParam("cuisine", "british")
                .queryParam("sort", "popularity")
                .queryParam("type", "dessert")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void fishSaladRecipesTest(){
        given()
                .queryParam("query", "salad")
                .queryParam("includeIngredients", "fish")
                .queryParam("type", "salad")
                .queryParam("number", 7)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void mexicanChickenTest(){
        given()
                .queryParam("cuisine", "mexican")
                .queryParam("includeIngredients", "chicken")
                .queryParam("type", "side dish")
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }

    @Test
    void indianVegetarianDishesTest(){
        given()
                .queryParam("cuisine", "indian")
                .queryParam("type", "main course")
                .queryParam("diet", "vegetarian")
                .queryParam("sort", "time")
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then();
    }
}