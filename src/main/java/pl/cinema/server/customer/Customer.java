package pl.cinema.server.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
class Customer {
    @Id
    private Long id;
    private String name;
    private String surname;
}
