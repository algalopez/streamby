package com.algalopez.streamby.event_app.producer.api;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class EventControllerApiTest {

  @Test
  void getAllEvents() {
    given().when().get("/event/producer/event").then().statusCode(204);
  }
}
