package pl.cinema.server.customer.domain;

import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class SavedCustomerDetails {
    private UUID uuid;
    private LocalDate birthDate;
    private CustomerType customerType;

    public static SavedCustomerDetails valueOf(Customer customer) {
        return new SavedCustomerDetails(customer.getUuid(), customer.getBirthDate(), customer.getCustomerType());
    }
}
