package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryViewPort;
import com.algalopez.streamby.shared.application.QueryActor;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class GetAllCategoriesActor implements QueryActor<Void, GetAllCategoriesResponse> {

  private final CategoryViewPort categoryViewPort;
  private final GetAllCategoriesMapper mapper;

  @Override
  public GetAllCategoriesResponse query(Void unused) {
    List<CategoryView> categories = categoryViewPort.findAllCategories();
    return mapper.mapToResponse(categories);
  }
}
