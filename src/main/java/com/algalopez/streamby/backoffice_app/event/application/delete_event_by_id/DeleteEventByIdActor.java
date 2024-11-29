package com.algalopez.streamby.backoffice_app.event.application.delete_event_by_id;

import com.algalopez.streamby.shared.application.CommandActor;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class DeleteEventByIdActor implements CommandActor<String> {

    public void command(String id) {
        log.info("Deleting event: {}", id);
    }
}
