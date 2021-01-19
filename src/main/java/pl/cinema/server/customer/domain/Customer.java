package pl.cinema.server.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    private CustomerType customerType; //or we can create generic field here, customerType? or DicountType
}
