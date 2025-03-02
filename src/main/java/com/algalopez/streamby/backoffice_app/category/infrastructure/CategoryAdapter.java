package com.algalopez.streamby.backoffice_app.category.infrastructure;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class CategoryAdapter implements CategoryPort {
  @Override
  public Category findCategoryById(Long id) {
    log.info("findCategoryById");
    return null;
  }

  @Override
  public Category createCategory(Category category) {
    log.info("createCategory");
    return null;
  }

  @Override
  public void updateCategory(Category category) {
    log.info("updateCategory");
  }

  @Override
  public void removeCategory(Long id) {
    log.info("removeCategory");
  }
}
