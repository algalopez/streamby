package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdRequest;
import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import java.util.List;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class GetCategoryByIdControllerApiTest {

  @InjectMock GetCategoryByIdActor actor;

  @Test
  void getCategoryById() {
    GetCategoryByIdResponse response = buildResponse();
    Mockito.when(actor.query(Mockito.any(GetCategoryByIdRequest.class))).thenReturn(response);

    RestAssured.given()
        .when()
        .get("/backoffice-app/category/1")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(200)
        .body("id", Is.is(1))
        .body("name", Is.is("name1"))
        .body("subcategories.size()", Is.is(1))
        .body("subcategories[0].id", Is.is(2))
        .body("subcategories[0].name", Is.is("name2"));

    Mockito.verify(actor).query(GetCategoryByIdRequest.builder().categoryId(1L).build());
  }

  private GetCategoryByIdResponse buildResponse() {
    return GetCategoryByIdResponse.builder()
        .id(1L)
        .name("name1")
        .subcategories(
            List.of(GetCategoryByIdResponse.Subcategory.builder().id(2L).name("name2").build()))
        .build();
  }
}
