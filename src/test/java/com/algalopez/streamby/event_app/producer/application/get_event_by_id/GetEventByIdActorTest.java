package com.algalopez.streamby.event_app.producer.application.get_event_by_id;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class GetEventByIdActorTest {

  private GetEventByIdActor getEventByIdActor;

  @BeforeEach
  void setUp() {
    getEventByIdActor = new GetEventByIdActor();
  }

  @Test
  void query() {
    String id = UUID.randomUUID().toString();

    assertThatNoException().isThrownBy(() -> getEventByIdActor.query(id));
  }
}
