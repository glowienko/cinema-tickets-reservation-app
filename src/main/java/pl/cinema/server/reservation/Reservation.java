package pl.cinema.server.reservation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import pl.cinema.server.cinema.Seat;
import pl.cinema.server.screening.Screening;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    //todo: such fields can be moved to abstract entity and shared between all entities if needed
    //but this may not be an issue. also @LastModifiedDate is a nice annotation for auditing, or hibernate Envers
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @ManyToMany
    @JoinTable(
            name = "reservation_seats",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Maker maker;
}
