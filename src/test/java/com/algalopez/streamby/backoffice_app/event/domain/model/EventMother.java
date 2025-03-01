package com.algalopez.streamby.backoffice_app.event.domain.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(fluent = true)
@Setter
public class EventMother {

  private UUID id;
  private String name;
  private LocalDateTime startDateTime;
  private Long categoryId;
  private Long subCategoryId;

  public EventMother() {
    var faker = new Faker();
    this.id = UUID.randomUUID();
    this.name = faker.text().text(10, 50);
    this.startDateTime =
        faker.timeAndDate().future(100, TimeUnit.DAYS).atOffset(ZoneOffset.UTC).toLocalDateTime();
    this.categoryId = faker.number().numberBetween(1L, 1000L);
    this.subCategoryId = faker.number().numberBetween(1L, 1000L);
  }

  public Event build() {
    return Event.builder()
        .id(id)
        .name(name)
        .startDateTime(startDateTime)
        .categoryId(categoryId)
        .subCategoryId(subCategoryId)
        .build();
  }
}
