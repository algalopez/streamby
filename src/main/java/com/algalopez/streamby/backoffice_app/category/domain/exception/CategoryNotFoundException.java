package com.algalopez.streamby.backoffice_app.category.domain.exception;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(String message) {
    super(message);
  }
}
