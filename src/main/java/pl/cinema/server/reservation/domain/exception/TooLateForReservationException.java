package pl.cinema.server.reservation.domain.exception;

public class TooLateForReservationException extends RuntimeException {
    public TooLateForReservationException() {
    }

    public TooLateForReservationException(String message) {
        super(message);
    }
}
