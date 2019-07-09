package pl.cinema.server.reservation.validation

import pl.cinema.server.screening.SeatStatus
import spock.lang.Specification
import spock.lang.Unroll

class FreeSeatValidatorSpec extends Specification {
    def objectUnderTest = new FreeSeatValidator()

    @Unroll
    def "should validate as true only free seat"() {
        expect:
            objectUnderTest.isValid(seatStatus, null) == expectedResult

        where:
            seatStatus       || expectedResult
            SeatStatus.FREE  || true
            SeatStatus.TAKEN || false


    }

}
