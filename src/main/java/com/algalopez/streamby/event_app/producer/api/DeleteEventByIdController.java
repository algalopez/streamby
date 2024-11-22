package com.algalopez.streamby.event_app.producer.api;

import com.algalopez.streamby.event_app.producer.application.delete_event_by_id.DeleteEventByIdActor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Events")
@RequiredArgsConstructor
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteEventByIdController {

  private final DeleteEventByIdActor deleteEventByIdActor;

  @Operation(summary = "Delete event by id")
  @APIResponse(responseCode = "204")
  @DELETE
  @Path("/event/{id}")
  public void getEventById(@PathParam("id") String id) {
    deleteEventByIdActor.command(id);
  }
}
