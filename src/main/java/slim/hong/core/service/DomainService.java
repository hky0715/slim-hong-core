package slim.hong.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import slim.hong.core.model.event.UserEvent;

/**
 * @see https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events
 */
@Service
public class DomainService implements ApplicationEventPublisherAware {

    private Logger log = LoggerFactory.getLogger(DomainService.class);
    private ApplicationEventPublisher eventPublisher;

    // @Transactional
    public void triggerEvent(String username) {
        // Publish Domain Event
        log.info("Start processing... [username={}]", username);
        //TODO: Execute Original Domain Logic
        eventPublisher.publishEvent(username);
        eventPublisher.publishEvent(new UserEvent(username));
        log.info("End processing...");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;     
    }
    
}
