package com.algalopez.streamby.event_app.producer.api;

import static io.restassured.RestAssured.given;

import com.algalopez.streamby.event_app.producer.application.delete_event_by_id.DeleteEventByIdActor;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class DeleteEventByIdControllerApiTest {

  @InjectMock DeleteEventByIdActor deleteEventByIdActor;

  @Test
  void deleteEvent() {
    Mockito.doNothing().when(deleteEventByIdActor).command(Mockito.anyString());

    given()
        .contentType(ContentType.JSON)
        .pathParam("id", 1)
        .when()
        .delete("/event/producer/event/{id}")
        .then()
        .statusCode(StatusCode.NO_CONTENT);

    Mockito.verify(deleteEventByIdActor).command("1");
  }
}
