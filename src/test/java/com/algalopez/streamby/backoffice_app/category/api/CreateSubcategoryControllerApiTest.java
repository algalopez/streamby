package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.create_subcategory.CreateSubcategoryActor;
import com.algalopez.streamby.backoffice_app.category.application.create_subcategory.CreateSubcategoryRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class CreateSubcategoryControllerApiTest {

  @InjectMock CreateSubcategoryActor actor;

  @Test
  void createSubcategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(CreateSubcategoryRequest.class));
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
        .post("/backoffice-app/category/{categoryId}/subcategory")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(RestResponse.StatusCode.NO_CONTENT);

    Mockito.verify(actor)
        .command(CreateSubcategoryRequest.builder().categoryId(1L).name("name").build());
  }
}
