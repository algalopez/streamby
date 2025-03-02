package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UpdateCategoryByIdMapper {

  @Mapping(target = "id", source = "categoryId")
  Category mapToDomain(UpdateCategoryByIdRequest request);
}
