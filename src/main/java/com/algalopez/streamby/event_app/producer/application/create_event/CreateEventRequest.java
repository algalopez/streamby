package com.algalopez.streamby.event_app.producer.application.create_event;

import lombok.Builder;

@Builder
public record CreateEventRequest(
    String id,
    String name,
    String date,
    String type,
    String category,
    String interactionType,
    String interactionSubType) {}
