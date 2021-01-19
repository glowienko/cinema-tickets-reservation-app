package pl.cinema.server.reservation.domain.exception;

public class TakenPlaceSelectedException extends RuntimeException {
    public TakenPlaceSelectedException() {
    }

    public TakenPlaceSelectedException(String message) {
        super(message);
    }
}
