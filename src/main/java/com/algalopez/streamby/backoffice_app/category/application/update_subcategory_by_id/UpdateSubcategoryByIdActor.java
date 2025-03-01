package com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpdateSubcategoryByIdActor implements CommandActor<UpdateSubcategoryByIdRequest> {
  @Override
  public void command(UpdateSubcategoryByIdRequest updateSubcategoryByIdRequest) {}
}
