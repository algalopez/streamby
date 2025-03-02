package com.algalopez.streamby.backoffice_app.category.domain.port;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import java.util.List;

public interface CategoryViewPort {

  List<CategoryView> findAllCategories();

  CategoryView findCategoryById(Long id);
}
