package pl.cinema.server.customer.dto;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class CustomerDto {
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private Boolean isStudent; //or we can create generic field here, customerType? or DicountType

}
