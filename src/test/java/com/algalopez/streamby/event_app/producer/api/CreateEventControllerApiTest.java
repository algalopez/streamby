package com.algalopez.streamby.event_app.producer.api;

import static io.restassured.RestAssured.given;

import com.algalopez.streamby.event_app.producer.application.create_event.CreateEventActor;
import com.algalopez.streamby.event_app.producer.application.create_event.CreateEventRequest;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
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
      "date": "date",
      "type": "type",
      "category": "category",
      "interactionType": "interactionType",
      "interactionSubType": "interactionSubType"
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
                .date("date")
                .type("type")
                .category("category")
                .interactionType("interactionType")
                .interactionSubType("interactionSubType")
                .build());
  }
}
