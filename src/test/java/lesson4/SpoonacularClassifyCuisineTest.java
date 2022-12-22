package lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularClassifyCuisineTest extends AbstractTest{

    private static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() {
        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", getApiKey())
                .addQueryParam("language", "en")
                .setContentType("application/x-www-form-urlencoded")
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpecification;
    }

    @Test
    void classifyClamsWithSpanishSausage(){
        given()
                .formParam("title", "Clams With Spanish Sausage")
                .formParam("ingredientList", "potato\nfish")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyApplePieTest(){
        given()
                .formParam("title", "Apple Pie, Vermont Style")
                .formParam("ingredientList", "apple")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyEggSaladTest(){
        given()
                .formParam("title", "Egg Salad Sandwiches With Tarragon")
                .formParam("ingredientList", "egg\nblack pepper\nmayonnaise")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyCrabSaladTest(){
        given()
                .formParam("title", "Crab Salad Stuffed Pita Pockets")
                .formParam("ingredientList", "apple\npita breads\nwatercress")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifySausageAndPepperoniStromboliTest(){
        given()
                .formParam("title", "Sausage & Pepperoni Stromboli")
                .formParam("ingredientList", "mozzarella cheese\nbacon\npepperoni")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyPotatoSoupTest(){
        given()
                .formParam("title", "Loaded Baked Potato Soup")
                .formParam("ingredientList", "bacon\nmilk\nchopped onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyRamenTest(){
        given()
                .formParam("title", "Homemade Creamy Ramen Soup")
                .formParam("ingredientList", "coconut oil\ncloves garlic\nyellow onion")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyVeganDirtyChaiPuddingTest(){
        given()
                .formParam("title", "Vegan Dirty Chai Pudding")
                .formParam("ingredientList", "avocados\nvanilla\nginger")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyMuesliCookiesTest(){
        given()
                .formParam("title", "Muesli Cookies")
                .formParam("ingredientList", "muesli\negg")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }

    @Test
    void classifyBLTPizzaTest(){
        given()
                .formParam("title", "BLT Pizza")
                .formParam("ingredientList", "bacon\nmozzarella cheese\ntomato")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .assertThat();
    }
}