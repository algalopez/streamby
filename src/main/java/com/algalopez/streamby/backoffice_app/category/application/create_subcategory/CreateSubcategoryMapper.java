package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CreateSubcategoryMapper {

  @Mapping(target = "id", ignore = true)
  Subcategory mapToDomain(CreateSubcategoryRequest createSubcategoryRequest);
}
