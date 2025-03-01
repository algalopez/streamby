package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import java.util.List;
import lombok.Builder;

@Builder
public record GetAllCategoriesResponse(List<Category> categories) {

  @Builder
  public record Category(Long id, String name, List<Subcategory> subcategories) {}

  @Builder
  public record Subcategory(Long id, String name) {}
}
