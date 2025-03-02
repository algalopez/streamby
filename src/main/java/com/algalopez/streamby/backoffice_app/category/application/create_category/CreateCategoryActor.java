package com.algalopez.streamby.backoffice_app.category.application.create_category;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class CreateCategoryActor implements CommandActor<CreateCategoryRequest> {

  private final CategoryPort categoryPort;
  private final CreateCategoryMapper mapper;

  @Override
  public void command(CreateCategoryRequest createCategoryRequest) {
    Category category = mapper.mapToDomain(createCategoryRequest);
    categoryPort.createCategory(category);
  }
}
