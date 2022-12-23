package lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularClassifyCuisineTest extends AbstractTest{

    @Test
    void classifyClamsWithSpanishSausage(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Clams With Spanish Sausage")
                .formParam("ingredientList", "potato\nfish")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyApplePieTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Apple Pie, Vermont Style")
                .formParam("ingredientList", "apple")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyEggSaladTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Egg Salad Sandwiches With Tarragon")
                .formParam("ingredientList", "egg\nblack pepper\nmayonnaise")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyCrabSaladTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Crab Salad Stuffed Pita Pockets")
                .formParam("ingredientList", "apple\npita breads\nwatercress")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifySausageAndPepperoniStromboliTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Sausage & Pepperoni Stromboli")
                .formParam("ingredientList", "mozzarella cheese\nbacon\npepperoni")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyPotatoSoupTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Loaded Baked Potato Soup")
                .formParam("ingredientList", "bacon\nmilk\nchopped onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyRamenTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Homemade Creamy Ramen Soup")
                .formParam("ingredientList", "coconut oil\ncloves garlic\nyellow onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyVeganDirtyChaiPuddingTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Vegan Dirty Chai Pudding")
                .formParam("ingredientList", "avocados\nvanilla\nginger")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyMuesliCookiesTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "Muesli Cookies")
                .formParam("ingredientList", "muesli\negg")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }

    @Test
    void classifyBLTPizzaTest(){
        Specifications.initSpecification(Specifications.requestSpecCuisine());
        given()
                .formParam("title", "BLT Pizza")
                .formParam("ingredientList", "bacon\nmozzarella cheese\ntomato")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then();
    }
}