package pl.cinema.server.reservation.domain.exception;

public class LeftOverPlaceBetweenTwoSeats extends RuntimeException {
    public LeftOverPlaceBetweenTwoSeats() {
    }

    public LeftOverPlaceBetweenTwoSeats(String message) {
        super(message);
    }
}
