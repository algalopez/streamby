package com.algalopez.streamby.backoffice_app.event.api;

import static io.restassured.RestAssured.given;

import com.algalopez.streamby.backoffice_app.event.application.create_event.CreateEventActor;
import com.algalopez.streamby.backoffice_app.event.application.create_event.CreateEventRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import java.util.List;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class CreateEventControllerApiTest {

  @InjectMock CreateEventActor createEventActor;

  @Test
  void createEvent() {
    Mockito.doNothing().when(createEventActor).command(Mockito.any(CreateEventRequest.class));
    String requestBody =
        """
    {
      "id": "id",
      "name": "name",
      "startDate": "startDate",
      "category": "category",
      "subCategory": "subCategory",
      "inputTypes": ["inputType"],
      "outputTypes": ["outputType"]
    }
    """;

    given()
        .body(requestBody)
        .contentType(ContentType.JSON)
        .when()
        .post("/event/producer/event")
        .then()
        .statusCode(RestResponse.StatusCode.NO_CONTENT);

    Mockito.verify(createEventActor)
        .command(
            CreateEventRequest.builder()
                .id("id")
                .name("name")
                .startDate("startDate")
                .category("category")
                .subCategory("subCategory")
                .inputTypes(List.of("inputType"))
                .outputTypes(List.of("outputType"))
                .build());
  }
}
