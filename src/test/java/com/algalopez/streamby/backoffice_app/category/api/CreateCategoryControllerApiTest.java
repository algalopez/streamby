package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.create_category.CreateCategoryActor;
import com.algalopez.streamby.backoffice_app.category.application.create_category.CreateCategoryRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class CreateCategoryControllerApiTest {

  @InjectMock CreateCategoryActor actor;

  @Test
  void createCategory() {
    Mockito.doNothing().when(actor).command(Mockito.any(CreateCategoryRequest.class));
    final String requestBody =
        """
    {
      "name": "name"
    }
    """;

    RestAssured.given()
        .body(requestBody)
        .contentType(ContentType.JSON)
        .when()
        .post("/backoffice-app/category/")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(StatusCode.NO_CONTENT);

    Mockito.verify(actor).command(CreateCategoryRequest.builder().name("name").build());
  }
}
