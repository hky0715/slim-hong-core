package slim.hong.core.controller;

import org.springframework.web.bind.annotation.*;
import slim.hong.core.model.Member;
import slim.hong.core.service.jdbc.BatchDomainService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class BatchDomainController {

    private final BatchDomainService batchDomainService;

    public BatchDomainController(BatchDomainService batchDomainService) {
        this.batchDomainService = batchDomainService;
    }
    @PostMapping
    public int[] createUsers(@RequestParam List<String> usernames) {
        var members = usernames
                .stream()
                .map(username -> new Member(username))
                .toList();

        return batchDomainService.bulkInsert(members);
    }
}
