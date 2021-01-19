package pl.cinema.server.customer.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class CustomerCreatorHandler {
    private final CustomerJpaRepository customerJpaRepository;

    public SavedCustomerDetails handleCustomerMadeReservationEvent(CustomerMadeReservationEvent event) {
        Customer newCustomer = Customer.builder()
                .uuid(UUID.randomUUID())
                .birthDate(event.getBirthDate())
                .customerType(event.getCustomerType())
                .name(event.getName())
                .surname(event.getSurname())
                .build();

        return SavedCustomerDetails.valueOf(customerJpaRepository.save(newCustomer));
    }
}
