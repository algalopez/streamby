package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.backoffice_app.category.domain.port.SubcategoryPort;
import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class CreateSubcategoryActor implements CommandActor<CreateSubcategoryRequest> {

  private final CategoryPort categoryPort;
  private final SubcategoryPort subcategoryPort;
  private final CreateSubcategoryMapper mapper;

  @Override
  public void command(CreateSubcategoryRequest request) {
    ensureCategoryExists(request.categoryId());
    Subcategory subcategory = mapper.mapToDomain(request);

    subcategoryPort.createSubcategory(subcategory);
  }

  private void ensureCategoryExists(Long categoryId) {
    Category category = categoryPort.findCategoryById(categoryId);
    if (category == null) {
      throw new CategoryNotFoundException("Category " + categoryId + " not found");
    }
  }
}
