package com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class UpdateSubcategoryByIdMapperTest {

  private final UpdateSubcategoryByIdMapper mapper =
      Mappers.getMapper(UpdateSubcategoryByIdMapper.class);

  @Test
  void mapToDomain() {
    UpdateSubcategoryByIdRequest request =
        UpdateSubcategoryByIdRequest.builder()
            .categoryId(1L)
            .subcategoryId(2L)
            .name("name")
            .build();

    Subcategory actualSubcategory = mapper.mapToDomain(request);

    assertThat(actualSubcategory)
        .matches(s -> s.id() == 2L, "id")
        .matches(s -> s.categoryId() == 1L, "categoryId")
        .matches(s -> s.name().equals("name"), "name");
  }
}
