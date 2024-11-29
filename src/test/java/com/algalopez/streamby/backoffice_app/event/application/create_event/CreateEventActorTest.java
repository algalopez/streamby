package com.algalopez.streamby.backoffice_app.event.application.create_event;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateEventActorTest {

  private CreateEventActor createEventActor;

  @BeforeEach
  void setUp() {
    createEventActor = new CreateEventActor();
  }

  @Test
  void command() {
    CreateEventRequest request = CreateEventRequest.builder().build();

    assertThatNoException().isThrownBy(() -> createEventActor.command(request));
  }
}
