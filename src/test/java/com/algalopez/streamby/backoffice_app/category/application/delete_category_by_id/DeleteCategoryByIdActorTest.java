package com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteCategoryByIdActorTest {

  private CategoryPort categoryPort;
  private DeleteCategoryByIdActor actor;

  @BeforeEach
  void setUp() {
    categoryPort = Mockito.mock(CategoryPort.class);
    actor = new DeleteCategoryByIdActor(categoryPort);
  }

  @Test
  void command() {
    var category = new CategoryMother().build();
    var request = DeleteCategoryByIdRequest.builder().categoryId(1L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(category);
    Mockito.doNothing().when(categoryPort).removeCategory(Mockito.anyLong());

    assertThatCode(() -> actor.command(request)).doesNotThrowAnyException();
  }

  @Test
  void command_whenCategoryDoesNotExist() {
    var request = DeleteCategoryByIdRequest.builder().categoryId(1L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(null);
    Mockito.doNothing().when(categoryPort).removeCategory(Mockito.anyLong());

    assertThatExceptionOfType(CategoryNotFoundException.class)
        .isThrownBy(() -> actor.command(request));
  }
}
