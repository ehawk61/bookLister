package es.meeknot.booklister;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<Object> healthcheck(
        @RequestHeader(
            value = "X-API-Version",
            defaultValue = "v1"
        ) String apiVersionNumber
    ) {
        return ResponseEntity.ok(Map.of("status", "RUNNING"));
    }
}
