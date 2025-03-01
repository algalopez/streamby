package com.algalopez.streamby.backoffice_app.user.domain.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record User(UUID id, String alias, String email, Boolean active) {}
