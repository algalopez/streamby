package com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.exception.SubcategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.SubcategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.backoffice_app.category.domain.port.SubcategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteSubcategoryByIdActorTest {

  private CategoryPort categoryPort;
  private SubcategoryPort subcategoryPort;
  private DeleteSubcategoryByIdActor actor;

  @BeforeEach
  void setUp() {
    categoryPort = Mockito.mock(CategoryPort.class);
    subcategoryPort = Mockito.mock(SubcategoryPort.class);
    actor = new DeleteSubcategoryByIdActor(categoryPort, subcategoryPort);
  }

  @Test
  void command() {
    var category = new CategoryMother().build();
    var subcategory = new SubcategoryMother().build();
    var request = DeleteSubcategoryByIdRequest.builder().categoryId(1L).subcategoryId(2L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(category);
    Mockito.when(subcategoryPort.findSubcategoryById(Mockito.anyLong())).thenReturn(subcategory);
    Mockito.doNothing().when(subcategoryPort).removeSubcategory(Mockito.anyLong());

    assertThatCode(() -> actor.command(request)).doesNotThrowAnyException();
  }

  @Test
  void command_whenCategoryDoesNotExist() {
    var request = DeleteSubcategoryByIdRequest.builder().categoryId(1L).subcategoryId(2L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(null);

    assertThatExceptionOfType(CategoryNotFoundException.class)
        .isThrownBy(() -> actor.command(request));
  }

  @Test
  void command_whenSubcategoryDoesNotExist() {
    var category = new CategoryMother().build();
    var request = DeleteSubcategoryByIdRequest.builder().categoryId(1L).subcategoryId(2L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(category);
    Mockito.when(subcategoryPort.findSubcategoryById(Mockito.anyLong())).thenReturn(null);

    assertThatExceptionOfType(SubcategoryNotFoundException.class)
        .isThrownBy(() -> actor.command(request));
  }
}
