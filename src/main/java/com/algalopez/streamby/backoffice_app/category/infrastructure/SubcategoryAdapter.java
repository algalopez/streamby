package com.algalopez.streamby.backoffice_app.category.infrastructure;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import com.algalopez.streamby.backoffice_app.category.domain.port.SubcategoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class SubcategoryAdapter implements SubcategoryPort {
  @Override
  public Subcategory findSubcategoryById(Long id) {
    log.info("findSubcategoryById");
    return null;
  }

  @Override
  public Subcategory createSubcategory(Subcategory subcategory) {
    log.info("createSubcategory");
    return null;
  }

  @Override
  public void updateSubcategory(Subcategory subcategory) {
    log.info("updateSubcategory");
  }

  @Override
  public void removeSubcategory(Long id) {
    log.info("removeSubcategory");
  }
}
