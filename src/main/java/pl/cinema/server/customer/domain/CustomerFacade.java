package pl.cinema.server.customer.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerCreatorHandler customerCreator;

    public SavedCustomerDetails customerMadeReservation(CustomerMadeReservationEvent event) {
        return customerCreator.handleCustomerMadeReservationEvent(event);
    }
}
