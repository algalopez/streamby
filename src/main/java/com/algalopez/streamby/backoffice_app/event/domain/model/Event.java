package com.algalopez.streamby.backoffice_app.event.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Event(
    UUID id, String name, LocalDateTime startDateTime, Long categoryId, Long subCategoryId) {}
