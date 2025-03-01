package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id.DeleteSubcategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id.DeleteSubcategoryByIdRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class DeleteSubcategoryControllerApiTest {

  @InjectMock DeleteSubcategoryByIdActor actor;

  @Test
  void deleteSubcategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(DeleteSubcategoryByIdRequest.class));

    RestAssured.given()
        .pathParam("categoryId", 1)
        .pathParam("subcategoryId", 1)
        .when()
        .delete("/backoffice-app/category/{categoryId}/subcategory/{subcategoryId}")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(204);

    Mockito.verify(actor)
        .command(DeleteSubcategoryByIdRequest.builder().categoryId(1L).subcategoryId(1L).build());
  }
}
