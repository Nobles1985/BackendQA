package lesson3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class SpoonacularClassifyCuisineTest extends AbstractTest{

    @Test
    void classifyClamsWithSpanishSausage(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
                .log().all()
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
}