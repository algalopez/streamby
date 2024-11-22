package com.algalopez.streamby.event_app.producer.api;

import com.algalopez.streamby.event_app.producer.application.create_event.CreateEventActor;
import com.algalopez.streamby.event_app.producer.application.create_event.CreateEventRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateEventController {

  private final CreateEventActor createEventActor;

  @POST
  @Path("/event")
  public void getEventById(CreateEventRequest request) {
    createEventActor.command(request);
  }
}
