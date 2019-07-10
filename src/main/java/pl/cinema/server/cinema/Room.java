package pl.cinema.server.cinema;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
class Room {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "room", cascade = ALL, orphanRemoval = true)
    private List<Seat> seats;

    @ManyToOne(optional = false)
    private Cinema cinema;
}
