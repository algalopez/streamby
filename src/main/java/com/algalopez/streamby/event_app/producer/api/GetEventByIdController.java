package com.algalopez.streamby.event_app.producer.api;

import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdActor;
import com.algalopez.streamby.event_app.producer.application.get_event_by_id.GetEventByIdResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Events")
@RequiredArgsConstructor
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetEventByIdController {

  private final GetEventByIdActor getEventByIdActor;

  @Operation(summary = "Create event")
  @APIResponse(
      responseCode = "200",
      content = @Content(schema = @Schema(implementation = GetEventByIdResponse.class)))
  @GET
  @Path("/event/{id}")
  public GetEventByIdResponse getEventById(@PathParam("id") String id) {
    return getEventByIdActor.query(id);
  }
}
