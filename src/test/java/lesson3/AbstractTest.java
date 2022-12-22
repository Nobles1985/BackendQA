package lesson3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    private static String username;
    private static String hash;

    @BeforeAll
    static void initTest() throws IOException{

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("baseUrl");
        username = prop.getProperty("username");
        hash = prop.getProperty("hash");
    }

    public static String getApiKey() { return  apiKey; }

    public static String getBaseUrl() { return baseUrl; }

    public static String getUsername() { return username; }

    public static String getHash() { return hash; }
}