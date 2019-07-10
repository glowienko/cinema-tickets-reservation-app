package pl.cinema.server.reservation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
class Maker {
    @Id
    private Long id;
    private String name;
    private String surname;
    private Long age;
}
