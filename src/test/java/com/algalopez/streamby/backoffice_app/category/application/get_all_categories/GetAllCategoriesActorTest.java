package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.SubcategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryViewPort;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class GetAllCategoriesActorTest {

  private CategoryViewPort categoryViewPort;
  private GetAllCategoriesActor actor;

  @BeforeEach
  void setUp() {
    categoryViewPort = Mockito.mock(CategoryViewPort.class);
    final GetAllCategoriesMapper mapper = Mappers.getMapper(GetAllCategoriesMapper.class);
    actor = new GetAllCategoriesActor(categoryViewPort, mapper);
  }

  @Test
  void query() {
    var subcategory = new SubcategoryViewMother().build();
    var category = new CategoryViewMother().setSubcategories(List.of(subcategory)).build();
    Mockito.when(categoryViewPort.findAllCategories()).thenReturn(List.of(category));

    GetAllCategoriesResponse actualResponse = actor.query(null);

    assertThat(actualResponse)
        .isEqualTo(
            GetAllCategoriesResponse.builder()
                .categories(
                    List.of(
                        GetAllCategoriesResponse.Category.builder()
                            .id(category.id())
                            .name(category.name())
                            .subcategories(
                                List.of(
                                    GetAllCategoriesResponse.Subcategory.builder()
                                        .id(subcategory.id())
                                        .name(subcategory.name())
                                        .build()))
                            .build()))
                .build());
  }
}
