package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class UpdateCategoryByIdActor implements CommandActor<UpdateCategoryByIdRequest> {

  private final CategoryPort categoryPort;
  private final UpdateCategoryByIdMapper mapper;

  @Override
  public void command(UpdateCategoryByIdRequest request) {
    ensureCategoryExists(request.categoryId());
    Category category = mapper.mapToDomain(request);
    categoryPort.updateCategory(category);
  }

  private void ensureCategoryExists(Long categoryId) {
    Category category = categoryPort.findCategoryById(categoryId);
    if (category == null) {
      throw new CategoryNotFoundException("Category " + categoryId + " not found");
    }
  }
}
