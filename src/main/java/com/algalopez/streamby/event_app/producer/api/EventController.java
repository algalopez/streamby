package com.algalopez.streamby.event_app.producer.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/event/producer/")
@Produces(MediaType.APPLICATION_JSON)
public class EventController {

    @GET
    @Path("/event")
    public String getAllEvents() {
        return null;
    }
}
