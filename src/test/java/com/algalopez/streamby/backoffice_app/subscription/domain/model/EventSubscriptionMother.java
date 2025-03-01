package com.algalopez.streamby.backoffice_app.subscription.domain.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
class EventSubscriptionMother {
  private UUID id;
  private UUID userId;
  private UUID eventId;
  private UUID packageSubscriptionId;
  private LocalDateTime createdDateTime;

  public EventSubscriptionMother() {
    var faker = new Faker();
    this.id = UUID.randomUUID();
    this.userId = UUID.randomUUID();
    this.eventId = UUID.randomUUID();
    this.packageSubscriptionId = UUID.randomUUID();
    this.createdDateTime =
        faker.timeAndDate().future(100, TimeUnit.DAYS).atOffset(ZoneOffset.UTC).toLocalDateTime();
  }

  public EventSubscription build() {
    return EventSubscription.builder()
        .id(id)
        .userId(userId)
        .eventId(eventId)
        .packageSubscriptionId(packageSubscriptionId)
        .createdDateTime(createdDateTime)
        .build();
  }
}
