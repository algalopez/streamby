package com.algalopez.streamby.backoffice_app.category.domain.exception;

public class SubcategoryNotFoundException extends RuntimeException {
  public SubcategoryNotFoundException(String message) {
    super(message);
  }
}
