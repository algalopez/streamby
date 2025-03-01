package com.algalopez.streamby.backoffice_app._package.domain.model;

import java.time.Clock;
import java.time.LocalDate;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
public class PackageMother {
  private Long id;
  private String name;
  private Integer credits;
  private LocalDate startDate;
  private LocalDate endDate;

  public PackageMother() {
    var faker = new Faker();
    this.id = faker.number().numberBetween(1L, 1000L);
    this.name = faker.text().text(10, 50);
    this.credits = faker.number().numberBetween(1, 10000);
    this.startDate = LocalDate.now(Clock.systemUTC());
    this.endDate = LocalDate.now(Clock.systemUTC());
  }

  public Package build() {
    return Package.builder()
        .id(id)
        .name(name)
        .credits(credits)
        .startDate(startDate)
        .endDate(endDate)
        .build();
  }
}
