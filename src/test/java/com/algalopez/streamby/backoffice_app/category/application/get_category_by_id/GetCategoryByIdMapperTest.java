package com.algalopez.streamby.backoffice_app.category.application.get_category_by_id;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryViewMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.SubcategoryViewMother;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class GetCategoryByIdMapperTest {

  private final GetCategoryByIdMapper mapper = Mappers.getMapper(GetCategoryByIdMapper.class);

  @Test
  void mapToResponse() {
    var subcategory = new SubcategoryViewMother().build();
    var category = new CategoryViewMother().setSubcategories(List.of(subcategory)).build();

    GetCategoryByIdResponse actualResponse = mapper.mapToResponse(category);

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
