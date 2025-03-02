package com.algalopez.streamby.backoffice_app.category.application.create_category;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CreateCategoryMapper {

  @Mapping(target = "id", ignore = true)
  Category mapToDomain(CreateCategoryRequest createCategoryRequest);
}
