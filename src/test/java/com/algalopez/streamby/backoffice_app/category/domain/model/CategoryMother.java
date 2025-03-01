package com.algalopez.streamby.backoffice_app.category.domain.model;

import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
public class CategoryMother {
  private Long id;
  private String name;

  public CategoryMother() {
    var faker = new Faker();
    this.id = faker.number().numberBetween(1L, 1000L);
    this.name = faker.text().text(10, 50);
  }

  public Category build() {
    return Category.builder().id(id).name(name).build();
  }
}
