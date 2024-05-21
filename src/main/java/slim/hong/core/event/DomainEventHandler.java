package slim.hong.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import slim.hong.core.model.event.UserEvent;
import slim.hong.core.service.OtherDomainService;

@Component
public class DomainEventHandler {

    private Logger log = LoggerFactory.getLogger(DomainEventHandler.class);

    private OtherDomainService otherDomainService;

    public DomainEventHandler(OtherDomainService otherDomainService) {
        this.otherDomainService = otherDomainService;
    }

    @EventListener
    public void handle(String username) {
        log.info("Handle domain event. [username={}]", username);
    }

    @EventListener
    // @TransactionalEventListener
    public void handle(UserEvent event) {
        log.info("Handle domain event. [event.username={}]", event.getUsername());

        //TODO: Create argument for OtherDomainService.save(...)
        otherDomainService.save(event.getUsername());
    }

}
