package com.algalopez.streamby.backoffice_app.user.domain.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
class UserStateMother {
  private UUID id;
  private String alias;
  private Long creditsAvailable;
  private Long creditsUsed;
  private Long packagesSubscribed;
  private LocalDateTime lastEventSubscriptionDateTime;
  private Long eventsSubscribed;
  private LocalDateTime lastPackageSubscriptionDateTime;

  public UserStateMother() {
    var faker = new Faker();
    this.id = UUID.randomUUID();
    this.alias = faker.text().text(10, 50);
    this.creditsAvailable = faker.number().numberBetween(1L, 1000L);
    this.creditsUsed = faker.number().numberBetween(1L, 1000L);
    this.packagesSubscribed = faker.number().numberBetween(1L, 1000L);
    this.lastEventSubscriptionDateTime =
        faker.timeAndDate().past(100, TimeUnit.DAYS).atOffset(ZoneOffset.UTC).toLocalDateTime();
    this.eventsSubscribed = faker.number().numberBetween(1L, 1000L);
    this.lastPackageSubscriptionDateTime =
        faker.timeAndDate().past(100, TimeUnit.DAYS).atOffset(ZoneOffset.UTC).toLocalDateTime();
  }

  public UserState build() {
    return UserState.builder()
        .id(id)
        .alias(alias)
        .creditsAvailable(creditsAvailable)
        .creditsUsed(creditsUsed)
        .packagesSubscribed(packagesSubscribed)
        .lastEventSubscriptionDateTime(lastEventSubscriptionDateTime)
        .eventsSubscribed(eventsSubscribed)
        .lastPackageSubscriptionDateTime(lastPackageSubscriptionDateTime)
        .build();
  }
}
