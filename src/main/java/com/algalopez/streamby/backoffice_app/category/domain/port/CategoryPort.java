package com.algalopez.streamby.backoffice_app.category.domain.port;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;

public interface CategoryPort {

  Category findCategoryById(Long id);

  Category createCategory(Category category);

  void updateCategory(Category category);

  void removeCategory(Long id);
}
