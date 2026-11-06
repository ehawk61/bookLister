package es.meeknot.booklister;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpRequestTests {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void healthCheckWithProvidedHeadersShouldReturnProvidedHeadersInMessage() {
        var generatedUUID = UUID.randomUUID().toString();

        restTestClient
            .get()
            .uri("http://localhost:%d/healthcheck".formatted(port))
            .header("X-API-Version", "v1")
            .header("X-Correlation-Id", generatedUUID)
            .exchange()
            .expectBody()
            .jsonPath("$.correlationId")
            .isEqualTo(generatedUUID)
            .jsonPath("$.status")
            .isEqualTo("RUNNING")
            .jsonPath("$.apiVersion")
            .isEqualTo("v1");
    }
    @Test
    void healthCheckWithOnlyAPIHeaderShouldReturnProvidedHeaderAndGeneratedUUIDInMessage() {

        restTestClient
            .get()
            .uri("http://localhost:%d/healthcheck".formatted(port))
            .header("X-API-Version", "v1")
            .exchange()
            .expectBody()
            .jsonPath("$.correlationId")
            .value(String.class, value -> assertDoesNotThrow(() -> UUID.fromString(value)))
            .jsonPath("$.status")
            .isEqualTo("RUNNING")
            .jsonPath("$.apiVersion")
            .isEqualTo("v1");
    }
}
