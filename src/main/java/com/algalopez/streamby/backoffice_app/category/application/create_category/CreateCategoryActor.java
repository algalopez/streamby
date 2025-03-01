package com.algalopez.streamby.backoffice_app.category.application.create_category;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateCategoryActor implements CommandActor<CreateCategoryRequest> {

  @Override
  public void command(CreateCategoryRequest createCategoryRequest) {}
}
