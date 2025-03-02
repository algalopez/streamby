package com.algalopez.streamby.backoffice_app.category.application.create_category;

import static org.assertj.core.api.Assertions.assertThatCode;

import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class CreateCategoryActorTest {

  private CategoryPort categoryPort;
  private CreateCategoryActor actor;

  @BeforeEach
  void setUp() {
    categoryPort = Mockito.mock(CategoryPort.class);
    final CreateCategoryMapper mapper = Mappers.getMapper(CreateCategoryMapper.class);
    actor = new CreateCategoryActor(categoryPort, mapper);
  }

  @Test
  void command() {
    var category = new CategoryMother().build();
    Mockito.when(categoryPort.createCategory(Mockito.any(Category.class))).thenReturn(category);
    var request = CreateCategoryRequest.builder().name("name").build();

    assertThatCode(() -> actor.command(request)).doesNotThrowAnyException();
  }
}
