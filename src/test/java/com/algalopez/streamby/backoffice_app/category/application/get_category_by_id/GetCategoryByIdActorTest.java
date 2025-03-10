package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.SubcategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryViewPort;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class GetCategoryByIdActorTest {

  private CategoryViewPort categoryViewPort;
  private GetCategoryByIdActor actor;

  @BeforeEach
  void setUp() {
    categoryViewPort = Mockito.mock(CategoryViewPort.class);
    final GetCategoryByIdMapper mapper = Mappers.getMapper(GetCategoryByIdMapper.class);
    actor = new GetCategoryByIdActor(categoryViewPort, mapper);
  }

  @Test
  void query() {
    var subcategory = new SubcategoryViewMother().build();
    var category = new CategoryViewMother().setSubcategories(List.of(subcategory)).build();
    var request = GetCategoryByIdRequest.builder().categoryId(1L).build();
    Mockito.when(categoryViewPort.findCategoryById(Mockito.anyLong())).thenReturn(category);

    GetCategoryByIdResponse actualResponse = actor.query(request);

    assertThat(actualResponse)
        .isEqualTo(
            GetCategoryByIdResponse.builder()
                .id(category.id())
                .name(category.name())
                .subcategories(
                    List.of(
                        GetCategoryByIdResponse.Subcategory.builder()
                            .id(subcategory.id())
                            .name(subcategory.name())
                            .build()))
                .build());
  }
}
