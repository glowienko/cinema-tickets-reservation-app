package pl.cinema.server.screening.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "rooms")
class RoomQuery {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<ScreeningQuery> screenings;
}
