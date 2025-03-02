package com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id;

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
public class UpdateSubcategoryByIdActor implements CommandActor<UpdateSubcategoryByIdRequest> {

  private final CategoryPort categoryPort;
  private final SubcategoryPort subcategoryPort;
  private final UpdateSubcategoryByIdMapper mapper;

  @Override
  public void command(UpdateSubcategoryByIdRequest request) {
    ensureCategoryExists(request.categoryId());
    ensureSubcategoryExists(request.subcategoryId());
    Subcategory subcategory = mapper.mapToDomain(request);
    subcategoryPort.updateSubcategory(subcategory);
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
