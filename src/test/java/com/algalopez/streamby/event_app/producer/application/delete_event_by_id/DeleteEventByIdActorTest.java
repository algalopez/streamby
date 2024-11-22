package com.algalopez.streamby.event_app.producer.application.delete_event_by_id;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteEventByIdActorTest {

  private DeleteEventByIdActor deleteEventByIdActor;

  @BeforeEach
  void setUp() {
    deleteEventByIdActor = new DeleteEventByIdActor();
  }

  @Test
  void command() {
    String id = UUID.randomUUID().toString();

    assertThatNoException().isThrownBy(() -> deleteEventByIdActor.command(id));
  }
}
