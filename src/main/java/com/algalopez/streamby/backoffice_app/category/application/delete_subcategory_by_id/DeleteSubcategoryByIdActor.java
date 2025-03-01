package com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeleteSubcategoryByIdActor implements CommandActor<DeleteSubcategoryByIdRequest> {
  @Override
  public void command(DeleteSubcategoryByIdRequest request) {}
}
