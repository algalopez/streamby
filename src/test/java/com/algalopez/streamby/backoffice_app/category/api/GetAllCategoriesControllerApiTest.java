package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.get_all_categories.GetAllCategoriesActor;
import com.algalopez.streamby.backoffice_app.category.application.get_all_categories.GetAllCategoriesResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import java.util.List;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class GetAllCategoriesControllerApiTest {

  @InjectMock GetAllCategoriesActor actor;

  @Test
  void getAllCategories() {
    GetAllCategoriesResponse response = buildResponse();
    Mockito.when(actor.query(Mockito.any())).thenReturn(response);

    RestAssured.given()
        .when()
        .get("/backoffice-app/category/")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(200)
        .body("categories.size()", Is.is(1))
        .body("categories[0].id", Is.is(1))
        .body("categories[0].name", Is.is("name1"))
        .body("categories[0].subcategories.size()", Is.is(1))
        .body("categories[0].subcategories[0].id", Is.is(2))
        .body("categories[0].subcategories[0].name", Is.is("name2"));

    Mockito.verify(actor).query(null);
  }

  private GetAllCategoriesResponse buildResponse() {

    return GetAllCategoriesResponse.builder()
        .categories(
            List.of(
                GetAllCategoriesResponse.Category.builder()
                    .id(1L)
                    .name("name1")
                    .subcategories(
                        List.of(
                            GetAllCategoriesResponse.Subcategory.builder()
                                .id(2L)
                                .name("name2")
                                .build()))
                    .build()))
        .build();
  }
}
