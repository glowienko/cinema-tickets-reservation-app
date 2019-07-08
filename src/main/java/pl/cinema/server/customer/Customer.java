package pl.cinema.server.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.cinema.server.customer.dto.CustomerDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
class Customer {
    @Id
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private Boolean isStudent; //or we can create generic field here, customerType? or DicountType

    @OneToMany(mappedBy = "customer")
    private List<Voucher> vouchers;

    CustomerDto toCustomerDto() {
        return CustomerDto.builder()
                .id(id)
                .age(age)
                .isStudent(isStudent)
                .name(name)
                .surname(surname)
                .build();
    }
}
