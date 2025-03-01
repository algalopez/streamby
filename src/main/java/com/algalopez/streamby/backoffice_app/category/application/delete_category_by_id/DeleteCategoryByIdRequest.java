package com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id;

import lombok.Builder;

@Builder
public record DeleteCategoryByIdRequest(Long categoryId) {}
