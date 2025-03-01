package com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeleteCategoryByIdActor implements CommandActor<DeleteCategoryByIdRequest> {
  @Override
  public void command(DeleteCategoryByIdRequest categoryId) {}
}
