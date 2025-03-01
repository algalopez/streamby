package com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id;

import lombok.Builder;

@Builder
public record DeleteSubcategoryByIdRequest(Long categoryId, Long subcategoryId) {}
