package slim.hong.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import slim.hong.core.event.DomainEventHandler;

import java.util.Map;

@Service
public class OtherDomainService {

    private Logger log = LoggerFactory.getLogger(OtherDomainService.class);

    // @Transactional
    public Map<String, String> save(String username) {
        //TODO: Execute Original Domain Logic
        var newObject = Map.of("id", "0001_" + username, "username", username);
        log.info("Create new object from username. {}", newObject);
        return newObject;
    }

}
