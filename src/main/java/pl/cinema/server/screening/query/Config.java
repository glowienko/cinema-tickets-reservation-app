package pl.cinema.server.screening.query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ScreeningFinder screeningFinder(ScreeningJpaRepository jpaRepository) {
        return new ScreeningFinder(new ScreeningRepository(jpaRepository));
    }
}
