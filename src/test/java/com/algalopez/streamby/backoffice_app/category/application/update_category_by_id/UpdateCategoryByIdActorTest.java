package com.algalopez.streamby.backoffice_app.category.application.update_category_by_id;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.Category;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class UpdateCategoryByIdActorTest {

  private CategoryPort categoryPort;
  private UpdateCategoryByIdActor actor;

  @BeforeEach
  void setUp() {
    categoryPort = Mockito.mock(CategoryPort.class);
    final UpdateCategoryByIdMapper mapper = Mappers.getMapper(UpdateCategoryByIdMapper.class);
    actor = new UpdateCategoryByIdActor(categoryPort, mapper);
  }

  @Test
  void command() {
    var category = new CategoryMother().build();
    var request = UpdateCategoryByIdRequest.builder().categoryId(1L).name("name").build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(category);
    Mockito.doNothing().when(categoryPort).updateCategory(Mockito.any(Category.class));

    assertThatCode(() -> actor.command(request)).doesNotThrowAnyException();
  }

  @Test
  void command_whenCategoryDoesNotExist() {
    var request = UpdateCategoryByIdRequest.builder().categoryId(1L).name("name").build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(null);

    assertThatExceptionOfType(CategoryNotFoundException.class)
        .isThrownBy(() -> actor.command(request));
  }
}
