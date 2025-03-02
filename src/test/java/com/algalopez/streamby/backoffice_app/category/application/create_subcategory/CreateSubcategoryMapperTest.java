package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import static org.assertj.core.api.Assertions.assertThat;

import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CreateSubcategoryMapperTest {

  private final CreateSubcategoryMapper mapper = Mappers.getMapper(CreateSubcategoryMapper.class);

  @Test
  void mapToDomain() {
    var request = CreateSubcategoryRequest.builder().categoryId(1L).name("name").build();

    Subcategory actualSubcategory = mapper.mapToDomain(request);

    assertThat(actualSubcategory)
        .matches(s -> s.id() == null, "id")
        .matches(s -> s.categoryId().equals(1L), "categoryId")
        .matches(s -> s.name().equals("name"), "name");
  }
}
