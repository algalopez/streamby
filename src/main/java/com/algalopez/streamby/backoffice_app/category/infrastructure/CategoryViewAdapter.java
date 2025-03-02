package com.algalopez.streamby.backoffice_app.category.infrastructure;

import com.algalopez.streamby.backoffice_app.category.domain.model.CategoryView;
import com.algalopez.streamby.backoffice_app.category.domain.port.CategoryViewPort;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
public class CategoryViewAdapter implements CategoryViewPort {
    @Override
    public List<CategoryView> findAllCategories() {
        log.info("findAllCategories");
        return List.of();
    }

    @Override
    public CategoryView findCategoryById(Long id) {
        log.info("findCategoryById");
        return null;
    }
}
