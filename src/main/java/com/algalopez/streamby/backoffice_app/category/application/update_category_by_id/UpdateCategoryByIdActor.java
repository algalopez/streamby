package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpdateCategoryByIdActor implements CommandActor<UpdateCategoryByIdRequest> {
  @Override
  public void command(UpdateCategoryByIdRequest updateCategoryByIdRequest) {}
}
