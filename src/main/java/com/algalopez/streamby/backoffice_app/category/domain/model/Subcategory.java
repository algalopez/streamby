package com.algalopez.streamby.backoffice_app.category.domain.model;

import lombok.Builder;

@Builder
public record Subcategory(Long id, Long categoryId, String name) {}
