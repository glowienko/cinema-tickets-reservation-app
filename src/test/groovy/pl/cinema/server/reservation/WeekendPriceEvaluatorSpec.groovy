package pl.cinema.server.reservation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.time.LocalDateTime

@SpringBootTest
//@ContextConfiguration(classes = ServerApplication)
class WeekendPriceEvaluatorSpec extends Specification {

    private static final NOW = LocalDateTime.now()//clock.fixed() should be used

    @Autowired
    private WeekendPriceEvaluator objectUnderTest

    def "EvaluatePrice"() {
    }

    def "canHandle should return true during weekend"() {
        given:
            def givenDate = LocalDateTime.of(2019, 7, 6, 12, 0)
            LocalDateTime.now() >> givenDate

        expect:
            objectUnderTest.canHandle(null)

    }
}
