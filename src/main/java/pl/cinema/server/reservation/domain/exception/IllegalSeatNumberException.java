package pl.cinema.server.reservation.domain.exception;

public class IllegalSeatNumberException extends RuntimeException {
    public IllegalSeatNumberException() {
    }

    public IllegalSeatNumberException(String message) {
        super(message);
    }
}
