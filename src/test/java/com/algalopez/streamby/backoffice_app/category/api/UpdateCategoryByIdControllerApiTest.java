package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.update_category_by_id.UpdateCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.update_category_by_id.UpdateCategoryByIdRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class UpdateCategoryByIdControllerApiTest {

  @InjectMock UpdateCategoryByIdActor actor;

  @Test
  void updateCategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(UpdateCategoryByIdRequest.class));
    final String requestBody =
        """
    {
      "name": "name"
    }
    """;

    RestAssured.given()
        .pathParam("categoryId", 1L)
        .body(requestBody)
        .contentType(ContentType.JSON)
        .when()
        .put("/backoffice-app/category/{categoryId}")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(204);

    Mockito.verify(actor)
        .command(UpdateCategoryByIdRequest.builder().categoryId(1L).name("name").build());
  }
}
