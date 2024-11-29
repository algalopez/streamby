package com.algalopez.streamby.backoffice_app.event.application.create_event;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class CreateEventActor implements CommandActor<CreateEventRequest> {

  public void command(CreateEventRequest request) {
    log.info("Creating event: {}", request);
  }
}
