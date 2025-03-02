package com.algalopez.streamby.backoffice_app.category.application.create_category;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CreateCategoryMapperTest {

  private final CreateCategoryMapper mapper = Mappers.getMapper(CreateCategoryMapper.class);

  @Test
  void mapToDomain() {
    var request = CreateCategoryRequest.builder().name("name").build();

    Category actualCategory = mapper.mapToDomain(request);

    assertThat(actualCategory)
        .matches(c -> c.id() == null, "id")
        .matches(c -> c.name().equals("name"), "name");
  }
}
