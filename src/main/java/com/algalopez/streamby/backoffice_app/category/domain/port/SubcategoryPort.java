package com.algalopez.streamby.backoffice_app.category.domain.port;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;

public interface SubcategoryPort {
  Subcategory findSubcategoryById(Long id);

  Subcategory createSubcategory(Subcategory subcategory);

  void updateSubcategory(Subcategory subcategory);

  void removeSubcategory(Long id);
}
