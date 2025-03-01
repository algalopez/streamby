package com.algalopez.streamby.backoffice_app._package.domain.model;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record Package(
    Long id, String name, Integer credits, LocalDate startDate, LocalDate endDate) {}
