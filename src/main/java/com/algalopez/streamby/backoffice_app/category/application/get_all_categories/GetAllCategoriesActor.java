package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import com.algalopez.streamby.shared.application.QueryActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetAllCategoriesActor implements QueryActor<Void, GetAllCategoriesResponse> {
  @Override
  public GetAllCategoriesResponse query(Void unused) {
    return null;
  }
}
