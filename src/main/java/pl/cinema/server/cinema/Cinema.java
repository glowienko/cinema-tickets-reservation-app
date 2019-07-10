package pl.cinema.server.cinema;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinemas")
class Cinema {

    @Id
    private Long id;
    private String name;

    @OneToMany(fetch = LAZY, mappedBy = "cinema")
    private List<Room> rooms;
}
