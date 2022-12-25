package org.example.lesson5.api;

import okhttp3.ResponseBody;
import org.example.lesson5.dto.ProductControllerDto;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductController {

    @GET("products")
    Call<ResponseBody> getProducts();

    @GET("products/{id}")
    Call<ProductControllerDto> getProduct(@Path("id") int id);

    @POST("products")
    Call<ProductControllerDto> createProduct(@Body ProductControllerDto createProductRequest);

    @PUT("products")
    Call<ProductControllerDto> modifyProduct(@Body ProductControllerDto modifyProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);
}