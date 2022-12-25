import lombok.SneakyThrows;
import org.example.lesson5.api.CategoryController;
import org.example.lesson5.dto.CategoryResponseDto;
import org.example.lesson5.utils.RetrofitUtil;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetCategoryTest {

    static CategoryController categoryController;
    @BeforeAll
    static void beforeAll(){
        categoryController = RetrofitUtil.getRetrofit().create(CategoryController.class);
    }

    @Test
    @SneakyThrows
    void getCategoryByIdPositive(){
        Response<CategoryResponseDto> response = categoryController.getCategoryPositive(2).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Electronic"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Electronic")));
        assertThat(response.body().getProducts().get(0).getTitle(), equalTo("Samsung Watch X1000"));
        assertThat(response.body().getProducts().get(1).getTitle(), equalTo("LG TV 1"));
    }

    @Test
    @SneakyThrows
    void getCategoryByIdNegative() {
        Response<CategoryResponseDto> response = categoryController.getCategoryNegative(3).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }
}