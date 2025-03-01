package com.algalopez.streamby.backoffice_app.user.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record UserState(
    UUID id,
    String alias,
    Long creditsAvailable,
    Long creditsUsed,
    Long packagesSubscribed,
    LocalDateTime lastEventSubscriptionDateTime,
    Long eventsSubscribed,
    LocalDateTime lastPackageSubscriptionDateTime) {}
