package pl.cinema.server.reservation.validation

import spock.lang.Specification
import spock.lang.Unroll

class PersonNameValidatorSpec extends Specification {
    def objectUnderTest = new PersonNameValidator()

    @Unroll
    def "should validate given #name"() {
        expect:
            objectUnderTest.isValid(name, null) == expectedResult

        where:
            name                    || expectedResult
            "asdfassdf"                || false
            "BSDFFdfasd"               || false
            "ZSDFFdfasd"               || false
            "ZfasdD"                   || false
            "ZfaTdasdf"                || false
            "Msdsdf125"                || false
            "Msdsdf!@#!`~%^&**(()_+!~" || false
            "Masdfasdf"                || true


    }

}
