package org.example.lesson5.utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        long time1 = System.nanoTime();

        System.out.println(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        long time2 = System.nanoTime();

        System.out.println(String.format("Received response for %s in %.1fms%n%s%n%s",
                response.request().url(), (time2 - time1) / 1e6d, response.code(), response.headers()));
        return response;
    }
}