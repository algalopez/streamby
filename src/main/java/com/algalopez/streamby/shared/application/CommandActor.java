package com.algalopez.streamby.shared.application;

public interface CommandActor<T> {
  void command(T t);
}
