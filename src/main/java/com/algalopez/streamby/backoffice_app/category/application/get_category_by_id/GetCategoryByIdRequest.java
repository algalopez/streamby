package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import lombok.Builder;

@Builder
public record GetCategoryByIdRequest(Long categoryId) {}
