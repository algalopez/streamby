package com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.exception.SubcategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.backoffice_app.category.domain.port.SubcategoryPort;
import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class DeleteSubcategoryByIdActor implements CommandActor<DeleteSubcategoryByIdRequest> {

  private final CategoryPort categoryPort;
  private final SubcategoryPort subcategoryPort;

  @Override
  public void command(DeleteSubcategoryByIdRequest request) {
    ensureCategoryExists(request.categoryId());
    ensureSubcategoryExists(request.subcategoryId());
    subcategoryPort.removeSubcategory(request.subcategoryId());
  }

  private void ensureCategoryExists(Long categoryId) {
    Category category = categoryPort.findCategoryById(categoryId);
    if (category == null) {
      throw new CategoryNotFoundException("Category " + categoryId + " not found");
    }
  }

  private void ensureSubcategoryExists(Long subcategoryId) {
    Subcategory subcategory = subcategoryPort.findSubcategoryById(subcategoryId);
    if (subcategory == null) {
      throw new SubcategoryNotFoundException("Subcategory " + subcategoryId + " not found");
    }
  }
}
