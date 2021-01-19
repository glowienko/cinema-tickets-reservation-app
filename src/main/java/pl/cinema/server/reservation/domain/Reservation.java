package pl.cinema.server.reservation.domain;

import lombok.Builder;
import lombok.Getter;
import pl.cinema.server.customer.domain.CustomerType;
import pl.cinema.server.reservation.domain.exception.IllegalSeatNumberException;
import pl.cinema.server.reservation.domain.exception.LeftOverPlaceBetweenTwoSeats;
import pl.cinema.server.reservation.domain.exception.TakenPlaceSelectedException;
import pl.cinema.server.screening.query.domain.SeatStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.math.BigDecimal.valueOf;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static pl.cinema.server.customer.domain.CustomerType.ADULT;
import static pl.cinema.server.customer.domain.CustomerType.CHILD;
import static pl.cinema.server.customer.domain.CustomerType.STUDENT;

@Getter
@Builder
public class Reservation {

    private static final Map<String, BigDecimal> prices = Map.of(
            CHILD.name(), valueOf(12.5),
            STUDENT.name(), valueOf(18),
            ADULT.name(), valueOf(25)
    );

    //TODO: MOZE POWINIEN BYC JESZCZE OBIEKT TICKET? I JAKBY REZERWACJA GENERUJE TICKET NA FILM, DANE MIESCA Z DANĄ CENĄ PO ZNIŻKACH I LINK POTIWERDZAJĄCY? CHOCIAZ POTIWERDZAMY TICKET CZY RSERSERVCJE?
    UUID uuid;
    BigDecimal amount;
    ReservationStatus status;
    LocalDateTime expirationTime;
    String confirmationLink;
    List<SelectedSeat> selectedSeats;
    UUID reservationMakerId;

    public Reservation(UUID uuid, String confirmationLink, UUID reservationMakerId) {
        this.uuid = uuid;
        this.reservationMakerId = reservationMakerId;
        this.status = ReservationStatus.PENDING;
        this.confirmationLink = confirmationLink;
    }

    void make(List<SelectedSeat> selectedSeats, LocalDate birthDate, CustomerType customerType) {
        chooseSeats(selectedSeats);
        calculateTicketPrice(birthDate, customerType); //TODO: HERE SHOULD BE TICKET TIME FOR EACH SEAT PROBABLY- CUSTOMER CAN TAKE ONE ADULT TICKET AND SECOND SEAT FOR CHILD
    }

    boolean confirm() {
        if (status == ReservationStatus.CONFIRMED) {
            return true;
        }

        if (LocalDateTime.now().isBefore(expirationTime)) {
            status = ReservationStatus.CONFIRMED;
            return true;
        }

        status = ReservationStatus.EXPIRED;
        return false;
    }

    private void chooseSeats(List<SelectedSeat> customerSeats) {
        if (customerSeats.size() < 1) {
            throw new IllegalSeatNumberException();
        }

        if (!customerSeats.stream().allMatch(seat -> seat.getStatus() == SeatStatus.FREE)) {
            throw new TakenPlaceSelectedException();
        }

        checkEmptyPlaceBetweenTwoSeats(customerSeats);
        selectedSeats = customerSeats;
    }

    private void checkEmptyPlaceBetweenTwoSeats(List<SelectedSeat> selectedSeats) {
        Map<Long, List<Long>> seatsMap = selectedSeats.stream()
                .sorted(Comparator.comparing(SelectedSeat::getNumber))
                .collect(Collectors.groupingBy(SelectedSeat::getRow, mapping(SelectedSeat::getNumber, toList())));

        seatsMap.forEach((key, value) -> {
            List<Long> list = seatsMap.get(key);

            if (list.size() <= 1) {
                return;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i + 1) - list.get(i) > 1) {
                    throw new LeftOverPlaceBetweenTwoSeats();
                }
            }
        });
    }

    private void calculateTicketPrice(LocalDate birthDate, CustomerType customerType) {
        //todo: tutaj polityki do cen + ceny per bilety na dany typ

        if (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            BigDecimal basePrice = prices.get(CHILD.name());
            amount =  valueOf(selectedSeats.size()).multiply(basePrice);

        }

        if (STUDENT == customerType) {
            BigDecimal basePrice = prices.get(STUDENT.name());
            amount =  valueOf(selectedSeats.size()).multiply(basePrice);
        }


        amount = valueOf(selectedSeats.size()).multiply(prices.get(ADULT.name()));
    }


    //    @Size(min = 1) - min 1 selected seat
    //    @FreeSeat - selected seat must be free
}
