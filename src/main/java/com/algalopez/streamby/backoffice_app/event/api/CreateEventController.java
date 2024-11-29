package com.algalopez.streamby.backoffice_app.event.api;

import com.algalopez.streamby.backoffice_app.event.application.create_event.CreateEventActor;
import com.algalopez.streamby.backoffice_app.event.application.create_event.CreateEventRequest;
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
public class CreateEventController {

  private final CreateEventActor createEventActor;

  @Operation(summary = "Create event")
  @APIResponse(responseCode = "204")
  @POST
  @Path("/event")
  public void getEventById(CreateEventRequest request) {
    createEventActor.command(request);
  }
}
