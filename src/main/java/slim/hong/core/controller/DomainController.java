package slim.hong.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import slim.hong.core.service.DomainService;

@RestController
@RequestMapping("/api/domain")
public class DomainController {

    private DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping("/events")
    public String triggerDomainEvent(@RequestParam String username) {
        domainService.triggerEvent(username);
        return "OK";
    }

}
