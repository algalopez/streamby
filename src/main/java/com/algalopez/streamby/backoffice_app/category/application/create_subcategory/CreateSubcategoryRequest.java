package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record CreateSubcategoryRequest(Long categoryId, String name) {}
