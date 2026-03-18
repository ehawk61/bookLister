package es.meeknot.booklister;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private HealthCheckController healthCheckController;

    @Test
    void contextLoads() {
        assertThat(healthCheckController).isNotNull();
    }
}
