package com.algalopez.streamby.event_app.producer.api;

import com.algalopez.streamby.event_app.producer.application.delete_event_by_id.DeleteEventByIdActor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteEventByIdController {

  private final DeleteEventByIdActor deleteEventByIdActor;

  @DELETE
  @Path("/event/{id}")
  public void getEventById(@PathParam("id") String id) {
    deleteEventByIdActor.command(id);
  }
}
