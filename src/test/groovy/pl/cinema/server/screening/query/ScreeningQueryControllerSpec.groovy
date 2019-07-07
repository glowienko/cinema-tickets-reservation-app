package pl.cinema.server.screening.query

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.util.UriComponentsBuilder
import pl.cinema.server.ServerApplication
import spock.lang.Specification

import java.time.Duration
import java.time.LocalDateTime

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

//@WebMvcTest(controllers = ScreeningController)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ServerApplication)
class ScreeningQueryControllerSpec extends Specification {

    @Autowired
    private final MockMvc mvc

    @Autowired
    private final ObjectMapper objectMapper

    @Autowired
    private ScreeningFinder finder

    def "should return 200 OK with available screenings"() {
        given:
            populateRepo()
            def url = UriComponentsBuilder.fromUriString("/screenings")
                    .queryParam("start", objectMapper.writeValueAsString(LocalDateTime.now().minusDays(2)))
                    .queryParam("end", objectMapper.writeValueAsString(LocalDateTime.now().plusDays(1))).build().toUriString()

        when:
            def result = mvc.perform(get(url))

        then:
            result.andExpect(status().isOk())


    }

    def populateRepo() {
        def repo = (InMemoryScreeningRepository) finder.screeningRepository
        Movie movie = Movie.builder().id(1).length(Duration.ofMinutes(120)).title('MOVIE_NAME_1').build()
        repo.entities.add(
                ScreeningQuery.builder()
                        .id(1)
                        .start(LocalDateTime.now().minusDays(1).plusHours(2))
                        .end(LocalDateTime.now().minusDays(1).plusHours(4))
                        .movie(movie).build()
        )
    }

    @TestConfiguration
    class TestConfig {
        @Bean
        ScreeningFinder finder() {
            return new ScreeningFinder(new InMemoryScreeningRepository())
        }
    }

}
