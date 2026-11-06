package es.meeknot.booklister;

import java.util.Map;
import java.util.UUID;

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
        ) String apiVersionNumber,
        @RequestHeader (
            value = "X-Correlation-Id",
            required = false
        ) String correlationId
    ) {

        if (correlationId == null || correlationId.isBlank()){
            var generatedId = UUID.randomUUID().toString();
            return ResponseEntity.ok(
                Map.of("correlationId",generatedId, "apiVersion", apiVersionNumber, "status", "RUNNING")
            );
        }
        else {
            return ResponseEntity.ok(
                Map.of("correlationId",correlationId, "apiVersion", apiVersionNumber, "status", "RUNNING")
            );
        }

    }
}
