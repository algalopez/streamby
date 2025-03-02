package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class UpdateCategoryByIdMapperTest {

  private final UpdateCategoryByIdMapper mapper = Mappers.getMapper(UpdateCategoryByIdMapper.class);

  @Test
  void mapToDomain() {
    UpdateCategoryByIdRequest request =
        UpdateCategoryByIdRequest.builder().categoryId(1L).name("name").build();

    Category actualCategory = mapper.mapToDomain(request);

    assertThat(actualCategory)
        .matches(c -> c.id() == 1L, "id")
        .matches(c -> c.name().equals("name"), "name");
  }
}
