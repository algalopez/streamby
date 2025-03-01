package com.algalopez.streamby.backoffice_app.subscription.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record PackageSubscription(UUID id, UUID userId, UUID packageId, LocalDateTime createdDateTime) {}
