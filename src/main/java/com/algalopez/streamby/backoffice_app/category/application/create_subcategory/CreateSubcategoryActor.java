package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateSubcategoryActor implements CommandActor<CreateSubcategoryRequest> {
  @Override
  public void command(CreateSubcategoryRequest createSubcategoryRequest) {}
}
