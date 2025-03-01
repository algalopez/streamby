package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import com.algalopez.streamby.shared.application.QueryActor;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetCategoryByIdActor
    implements QueryActor<GetCategoryByIdRequest, GetCategoryByIdResponse> {
  @Override
  public GetCategoryByIdResponse query(GetCategoryByIdRequest getCategoryByIdRequest) {
    return null;
  }
}
