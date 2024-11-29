package com.algalopez.streamby.backoffice_app.event.application.get_event_by_id;

import com.algalopez.streamby.shared.application.QueryActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class GetEventByIdActor implements QueryActor<String, GetEventByIdResponse> {

  public GetEventByIdResponse query(String id) {
    log.info("Getting event: {}", id);
    return null;
  }
}
