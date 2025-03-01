package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record UpdateCategoryByIdRequest(Long categoryId, String name) {}
