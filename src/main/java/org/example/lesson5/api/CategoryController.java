package org.example.lesson5.api;

import org.example.lesson5.dto.CategoryResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryController {

    @GET("categories/{id}")
    Call<CategoryResponseDto> getCategoryPositive(@Path("id") int id);

    @GET("categories/{id}")
    Call<CategoryResponseDto> getCategoryNegative(@Path("id") int id);
}