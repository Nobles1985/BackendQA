import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.lesson5.api.ProductController;
import org.example.lesson5.dto.ProductControllerDto;
import org.example.lesson5.utils.RetrofitUtil;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {

    static ProductController productController;
    private static int id;
    ProductControllerDto product;
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll(){ productController = RetrofitUtil.getRetrofit().create(ProductController.class); }

    //Positive tests
    @Test
    @SneakyThrows
    void getProductsTest(){
        Response<ResponseBody> response = productController.getProducts().execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
    }

    @Test
    @SneakyThrows
    void getProductByIdPositiveTest(){
        Response<ProductControllerDto> response = productController.getProduct(1).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Milk"));
        assertThat(response.body().getPrice(), equalTo(95));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }

    @Test
    @SneakyThrows
    void operationsWithNewProductTest(){
        //create product
        product = new ProductControllerDto()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice(70);
        Response<ProductControllerDto> postResponse = productController.createProduct(product).execute();
        id = postResponse.body().getId();

        assertThat(postResponse.isSuccessful(), equalTo(true));
        assertThat(postResponse.code(), equalTo(201));

        //modify product
        product = new ProductControllerDto()
                .withId(id)
                .withTitle("ModifyProduct")
                .withCategoryTitle("Food")
                .withPrice(100);
        Response<ProductControllerDto> putResponse = productController.modifyProduct(product).execute();

        assertThat(putResponse.isSuccessful(), equalTo(true));
        assertThat(putResponse.code(), equalTo(200));
        assertThat(putResponse.body().getTitle(), equalTo("ModifyProduct"));
        assertThat(putResponse.body().getPrice(), equalTo(100));

        //delete product
        Response<ResponseBody> response = productController.deleteProduct(id).execute();

        assertThat(response.isSuccessful(), equalTo(true));
        assertThat(response.code(), equalTo(200));
    }

    //Negative tests
    @Test
    @SneakyThrows
    void getProductByIdNegativeTest(){
        Response<ProductControllerDto> response = productController.getProduct(7).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }

    @Test
    @SneakyThrows
    void createNewProductNegativeTest(){
        product = new ProductControllerDto()
                .withId(7)
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice(100);
        Response<ProductControllerDto> response = productController.createProduct(product).execute();

        assertThat(response.isSuccessful(), equalTo(false));
        assertThat(response.code(), equalTo(400));
    }

    @Test
    @SneakyThrows
    void repeatDeleteProductTest(){
        Response<ResponseBody> response = productController.deleteProduct(id).execute();

        assertThat(response.isSuccessful(), equalTo(false));
        assertThat(response.code(), equalTo(500));
    }
}