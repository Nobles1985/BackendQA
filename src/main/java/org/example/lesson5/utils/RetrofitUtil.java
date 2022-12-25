package org.example.lesson5.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class RetrofitUtil {

    Properties prop = new Properties();
    private static InputStream configFile;
    static {
        try {
            configFile = new FileInputStream("src/main/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public String getBaseURL() {
        prop.load(configFile);
        return prop.getProperty("url");
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(getBaseURL())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}