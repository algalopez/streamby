package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id.DeleteCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id.DeleteCategoryByIdRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class DeleteCategoryControllerApiTest {

  @InjectMock DeleteCategoryByIdActor actor;

  @Test
  void deleteCategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(DeleteCategoryByIdRequest.class));

    RestAssured.given()
        .pathParam("categoryId", 1)
        .when()
        .delete("/backoffice-app/category/{categoryId}")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(204);

    Mockito.verify(actor).command(DeleteCategoryByIdRequest.builder().categoryId(1L).build());
  }
}
