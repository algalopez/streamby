package com.algalopez.streamby.backoffice_app.event.application.create_event;

import java.util.List;
import lombok.Builder;

@Builder
public record CreateEventRequest(
    String id,
    String name,
    String startDate,
    String category,
    String subCategory,
    List<String> inputTypes,
    List<String> outputTypes) {}
