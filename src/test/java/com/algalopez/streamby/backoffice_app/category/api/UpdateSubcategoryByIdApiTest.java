package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id.UpdateSubcategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id.UpdateSubcategoryByIdRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class UpdateSubcategoryByIdApiTest {

  @InjectMock UpdateSubcategoryByIdActor actor;

  @Test
  void updateSubcategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(UpdateSubcategoryByIdRequest.class));
    final String requestBody =
        """
    {
      "name": "name"
    }
    """;

    RestAssured.given()
        .pathParam("categoryId", 1L)
        .pathParam("subcategoryId", 2L)
        .body(requestBody)
        .contentType(ContentType.JSON)
        .when()
        .put("/backoffice-app/category/{categoryId}/subcategory/{subcategoryId}")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(204);

    Mockito.verify(actor)
        .command(
            UpdateSubcategoryByIdRequest.builder()
                .categoryId(1L)
                .subcategoryId(2L)
                .name("name")
                .build());
  }
}
