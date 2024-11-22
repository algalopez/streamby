package com.algalopez.streamby.event_app.producer.application.get_event_by_id;

import lombok.Builder;

@Builder
public record GetEventByIdResponse(
    String id,
    String name,
    String date,
    String type,
    String category,
    String interactionType,
    String interactionSubType) {}
