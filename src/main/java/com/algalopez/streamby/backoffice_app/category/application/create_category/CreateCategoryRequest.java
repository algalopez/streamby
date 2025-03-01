package com.algalopez.streamby.backoffice_app.category.application.create_category;

import lombok.Builder;

@Builder
public record CreateCategoryRequest(String name) {}
