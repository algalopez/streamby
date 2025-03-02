package com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class DeleteCategoryByIdActor implements CommandActor<DeleteCategoryByIdRequest> {

  private final CategoryPort categoryPort;

  @Override
  public void command(DeleteCategoryByIdRequest request) {
    ensureCategoryExists(request.categoryId());
    categoryPort.removeCategory(request.categoryId());
  }

  private void ensureCategoryExists(Long categoryId) {
    Category category = categoryPort.findCategoryById(categoryId);
    if (category == null) {
      throw new CategoryNotFoundException("Category " + categoryId + " not found");
    }
  }
}
