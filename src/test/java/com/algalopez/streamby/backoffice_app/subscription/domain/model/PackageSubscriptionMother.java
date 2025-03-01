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
class PackageSubscriptionMother {
  private UUID id;
  private UUID userId;
  private UUID packageId;
  private LocalDateTime createdDateTime;

  public PackageSubscriptionMother() {
    var faker = new Faker();
    this.id = UUID.randomUUID();
    this.userId = UUID.randomUUID();
    this.packageId = UUID.randomUUID();
    this.createdDateTime =
        faker.timeAndDate().future(100, TimeUnit.DAYS).atOffset(ZoneOffset.UTC).toLocalDateTime();
  }

  public PackageSubscription build() {
    return PackageSubscription.builder()
        .id(id)
        .userId(userId)
        .packageId(packageId)
        .createdDateTime(createdDateTime)
        .build();
  }
}
