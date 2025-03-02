package com.algalopez.streamby.backoffice_app.category.application.create_subcategory;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.algalopez.streamby.backoffice_app.category.domain.exception.CategoryNotFoundException;
import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryMother;
import com.algalopez.streamby.backoffice_app.category.domain.model.Subcategory;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryPort;
import com.algalopez.streamby.backoffice_app.category.domain.port.SubcategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

class CreateSubcategoryActorTest {
  private CategoryPort categoryPort;
  private SubcategoryPort subcategoryPort;
  private CreateSubcategoryActor actor;

  @BeforeEach
  void setUp() {
    categoryPort = Mockito.mock(CategoryPort.class);
    subcategoryPort = Mockito.mock(SubcategoryPort.class);
    final CreateSubcategoryMapper mapper = Mappers.getMapper(CreateSubcategoryMapper.class);
    actor = new CreateSubcategoryActor(categoryPort, subcategoryPort, mapper);
  }

  @Test
  void command() {
    var request = CreateSubcategoryRequest.builder().name("subcategoryName").categoryId(1L).build();
    var category = new CategoryMother().setId(request.categoryId()).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(category);
    Mockito.when(subcategoryPort.createSubcategory(Mockito.any(Subcategory.class)))
        .thenAnswer(AdditionalAnswers.returnsFirstArg());

    assertThatCode(() -> actor.command(request)).doesNotThrowAnyException();
  }

  @Test
  void command_whenCategoryDoesNotExist() {
    var request = CreateSubcategoryRequest.builder().name("subcategoryName").categoryId(1L).build();
    Mockito.when(categoryPort.findCategoryById(Mockito.anyLong())).thenReturn(null);

    assertThatExceptionOfType(CategoryNotFoundException.class)
        .isThrownBy(() -> actor.command(request));
  }
}
