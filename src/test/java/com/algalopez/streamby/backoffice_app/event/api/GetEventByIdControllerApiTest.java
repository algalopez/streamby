package com.algalopez.streamby.backoffice_app.event.api;

import static io.restassured.RestAssured.given;

import com.algalopez.streamby.backoffice_app.event.application.get_event_by_id.GetEventByIdActor;
import com.algalopez.streamby.backoffice_app.event.application.get_event_by_id.GetEventByIdResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.util.List;
import org.hamcrest.Matchers;
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
            .startDate("startDate")
            .category("category")
            .subCategory("subCategory")
            .inputTypes(List.of("inputType"))
            .outputTypes(List.of("outputType"))
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
        .body("startDate", Is.is("startDate"))
        .body("category", Is.is("category"))
        .body("subCategory", Is.is("subCategory"))
        .body("inputTypes", Matchers.containsInAnyOrder("inputType"))
        .body("outputTypes", Matchers.containsInAnyOrder("outputType"));
  }
}
