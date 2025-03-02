package com.algalopez.streamby.backoffice_app.category.application.get_all_categories;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.SubcategoryViewMother;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class GetAllCategoriesMapperTest {

  private final GetAllCategoriesMapper mapper = Mappers.getMapper(GetAllCategoriesMapper.class);

  @Test
  void mapToResponse() {
    var subcategory = new SubcategoryViewMother().build();
    var category = new CategoryViewMother().setSubcategories(List.of(subcategory)).build();
    List<CategoryView> categories = List.of(category);

    GetAllCategoriesResponse actualResponse = mapper.mapToResponse(categories);

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
