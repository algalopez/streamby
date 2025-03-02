package com.algalopez.streamby.backoffice_app.category.domain.model;

import java.util.List;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
public class CategoryViewMother {

  private Long id;
  private String name;
  private List<SubcategoryView> subcategories;

  public CategoryViewMother() {
    var faker = new Faker();
    this.id = faker.number().numberBetween(1L, 1000L);
    this.name = faker.text().text(10, 50);
    this.subcategories = List.of(new SubcategoryViewMother().build());
  }

  public CategoryView build() {
    return CategoryView.builder().id(id).name(name).subcategories(subcategories).build();
  }
}
