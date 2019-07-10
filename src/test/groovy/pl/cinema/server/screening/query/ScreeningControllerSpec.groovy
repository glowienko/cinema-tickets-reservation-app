package pl.cinema.server.screening.query

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.util.UriComponentsBuilder
import spock.lang.Specification

import java.time.Duration

import static java.time.LocalDateTime.now
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = ScreeningController)
@ContextConfiguration(classes = ScreeningControllerTestConfig)
class ScreeningControllerSpec extends Specification {

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
                    .queryParam("start", objectMapper.writeValueAsString(now().minusDays(2).format(ISO_DATE_TIME)))
                    .queryParam("end", objectMapper.writeValueAsString(now().plusDays(1).format(ISO_DATE_TIME)))
                    .build().toUriString()

        when:
            def result = mvc.perform(get(url))

        then:
            result.andExpect(status().isOk())


    }

    def populateRepo() {
        InMemoryScreeningRepository repo = finder.screeningRepository
        Movie movie = Movie.builder().id(1).length(Duration.ofMinutes(120)).title('MOVIE_NAME_1').build()
        repo.entities.add(
                ScreeningQuery.builder()
                        .id(1)
                        .start(now().minusDays(1).plusHours(2))
                        .end(now().minusDays(1).plusHours(4))
                        .movie(movie).build()
        )
    }
}
