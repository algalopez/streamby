package com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UpdateSubcategoryByIdMapper {

  @Mapping(target = "id", source = "subcategoryId")
  Subcategory mapToDomain(UpdateSubcategoryByIdRequest updateSubcategoryByIdRequest);
}
