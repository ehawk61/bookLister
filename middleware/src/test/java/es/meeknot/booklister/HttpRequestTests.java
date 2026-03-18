package es.meeknot.booklister;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpRequestTests {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void healthCheckShouldReturnDefaultMessage() {
        restTestClient
            .get()
            .uri("http://localhost:%d/healthcheck".formatted(port))
            .header("X-API-Version", "v1")
            .exchange()
            .expectBody()
            .jsonPath("$.status")
            .isEqualTo("RUNNING");
    }
}
