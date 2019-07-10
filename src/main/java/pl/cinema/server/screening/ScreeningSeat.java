package pl.cinema.server.screening;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.cinema.server.cinema.Seat;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screening_seats")
class ScreeningSeat {

    @Id
    private Long id;

    @Enumerated(STRING)
    private SeatStatus status;

    @MapsId
    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id")
    private Screening screening;
}
