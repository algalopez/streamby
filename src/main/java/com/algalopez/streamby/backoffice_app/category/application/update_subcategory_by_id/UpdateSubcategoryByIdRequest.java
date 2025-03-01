package com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record UpdateSubcategoryByIdRequest(Long categoryId, Long subcategoryId, String name) {}
