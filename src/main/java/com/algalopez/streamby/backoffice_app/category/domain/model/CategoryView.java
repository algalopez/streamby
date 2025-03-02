package com.algalopez.streamby.backoffice_app.category.domain.model;

import lombok.Builder;

import java.util.List;

@Builder
public record CategoryView(Long id, String name, List<SubcategoryView> subcategories) {}
