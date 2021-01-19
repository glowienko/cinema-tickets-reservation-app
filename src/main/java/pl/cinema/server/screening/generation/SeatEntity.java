package pl.cinema.server.screening.generation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "seats")
class SeatEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long row;
    private Long number;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;
}
