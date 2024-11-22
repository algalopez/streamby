package com.algalopez.streamby.shared.application;

public interface QueryActor<I, O> {
  O query(I i);
}
