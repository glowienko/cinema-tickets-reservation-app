package pl.cinema.server.cinema;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
class Room {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Seat> seats;

    @ManyToOne
    private Cinema cinema;
}
