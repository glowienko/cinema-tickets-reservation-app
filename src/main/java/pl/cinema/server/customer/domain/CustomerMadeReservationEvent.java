package pl.cinema.server.customer.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class CustomerMadeReservationEvent {

    String name;
    String surname;
    LocalDate birthDate;
    String voucherCode; //todo: might be not needed here
    CustomerType customerType;
}
