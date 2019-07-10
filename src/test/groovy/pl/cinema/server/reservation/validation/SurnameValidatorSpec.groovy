package pl.cinema.server.reservation.validation

import spock.lang.Specification
import spock.lang.Unroll

class SurnameValidatorSpec extends Specification {
    def objectUnderTest = new SurnameValidator()

    @Unroll
    def "should validate given #surname"() {
        expect:
            objectUnderTest.isValid(surname, null) == expectedResult

        where:
            surname                  || expectedResult
            "asdfassdf"              || false
            "BSDFFdfasd"             || false
            "ZSDFFdfasd"             || false
            "ZfasdD"                 || false
            "ZfaTdasdf"              || false
            "Zas234234"              || false
            "Zasaszdf#!_+!@#$_~^&&%" || false
            "Msdsdf-"                || false
            "Msdsdf-asdfasdf"        || false
            "sdsdf-Msdfasdf"         || false
            "ASdfasdf-MsdFsdf"       || false
            "Masdfasdf"              || true
            "Msdsdf-Cssdf"           || true

    }

}
