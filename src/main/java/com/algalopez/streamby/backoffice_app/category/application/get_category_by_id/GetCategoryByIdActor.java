package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryViewPort;
import com.algalopez.streamby.shared.application.QueryActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class GetCategoryByIdActor
    implements QueryActor<GetCategoryByIdRequest, GetCategoryByIdResponse> {

  private final CategoryViewPort categoryViewPort;
  private final GetCategoryByIdMapper mapper;

  @Override
  public GetCategoryByIdResponse query(GetCategoryByIdRequest getCategoryByIdRequest) {
    CategoryView category = categoryViewPort.findCategoryById(getCategoryByIdRequest.categoryId());
    return mapper.mapToResponse(category);
  }
}
