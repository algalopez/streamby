package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface GetAllCategoriesMapper {

  default GetAllCategoriesResponse mapToResponse(List<CategoryView> categories) {
    return GetAllCategoriesResponse.builder()
        .categories(categories.stream().map(this::mapCategory).toList())
        .build();
  }

  GetAllCategoriesResponse.Category mapCategory(CategoryView category);
}
