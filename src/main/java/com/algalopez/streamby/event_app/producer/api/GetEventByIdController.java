package com.algalopez.streamby.event_app.producer.api;

import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdActor;
import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetEventByIdController {

  private final GetEventByIdActor getEventByIdActor;

  @GET
  @Path("/event/{id}")
  public GetEventByIdResponse getEventById(@PathParam("id") String id) {
    return getEventByIdActor.query(id);
  }
}
