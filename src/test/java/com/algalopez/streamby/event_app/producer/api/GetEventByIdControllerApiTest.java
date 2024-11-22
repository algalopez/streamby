package com.algalopez.streamby.event_app.producer.api;

import static io.restassured.RestAssured.given;

import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdActor;
import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class GetEventByIdControllerApiTest {

  @InjectMock GetEventByIdActor getEventByIdActor;

  @Test
  void getEventById() {
    GetEventByIdResponse response =
        GetEventByIdResponse.builder()
            .id("id")
            .name("name")
            .date("date")
            .type("type")
            .category("category")
            .interactionType("interactionType")
            .interactionSubType("interactionSubType")
            .build();
    Mockito.when(getEventByIdActor.query(Mockito.anyString())).thenReturn(response);

    given()
        .contentType(ContentType.JSON)
        .pathParam("id", 1)
        .when()
        .get("/event/producer/event/{id}")
        .then()
        .log()
        .ifValidationFails(LogDetail.BODY)
        .statusCode(RestResponse.StatusCode.OK)
        .body("id", Is.is("id"))
        .body("name", Is.is("name"))
        .body("date", Is.is("date"))
        .body("type", Is.is("type"))
        .body("category", Is.is("category"))
        .body("interactionType", Is.is("interactionType"))
        .body("interactionSubType", Is.is("interactionSubType"));
  }
}
