package com.algalopez.streamby.backoffice_app.subscription.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record EventSubscription(
    UUID id,
    UUID userId,
    UUID eventId,
    UUID packageSubscriptionId,
    LocalDateTime createdDateTime) {}
