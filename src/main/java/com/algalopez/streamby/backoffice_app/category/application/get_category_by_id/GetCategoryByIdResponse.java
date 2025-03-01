package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import java.util.List;
import lombok.Builder;

@Builder
public record GetCategoryByIdResponse(Long id, String name, List<Subcategory> subcategories) {

  @Builder
  public record Subcategory(Long id, String name) {}
}
