package slim.hong.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OtherDomainEventHandler {

    private Logger log = LoggerFactory.getLogger(OtherDomainEventHandler.class);

    @EventListener
    public void handle(String username) {
        log.info("Handle domain event. [username={}]", username);
    }

}
