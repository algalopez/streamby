package com.algalopez.streamby.backoffice_app.event.application.get_event_by_id;

import java.util.List;
import lombok.Builder;

@Builder
public record GetEventByIdResponse(
    String id,
    String name,
    String startDate,
    String category,
    String subCategory,
    List<String> inputTypes,
    List<String> outputTypes) {}
