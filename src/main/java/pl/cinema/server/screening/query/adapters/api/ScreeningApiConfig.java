package pl.cinema.server.screening.query.adapters.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.cinema.server.screening.query.domain.ScreeningFinder;

@Configuration
class ScreeningApiConfig {

    @Bean
    ScreeningApiService screeningApiService(ScreeningFinder screeningFinder) {
        return new ScreeningApiService(screeningFinder);
    }
}
