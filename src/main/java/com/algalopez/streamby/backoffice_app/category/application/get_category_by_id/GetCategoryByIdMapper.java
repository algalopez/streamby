package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface GetCategoryByIdMapper {

  GetCategoryByIdResponse mapToResponse(CategoryView category);
}
