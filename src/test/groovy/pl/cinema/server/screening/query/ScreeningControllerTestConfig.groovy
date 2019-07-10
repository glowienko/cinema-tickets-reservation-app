package pl.cinema.server.screening.query

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class ScreeningControllerTestConfig {

    @Bean
    ScreeningFinder finder() {
        return new ScreeningFinder(new InMemoryScreeningRepository())
    }
}
