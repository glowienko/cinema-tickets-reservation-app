package pl.cinema.server.reservation.adapters.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import pl.cinema.server.reservation.domain.Reservation;
import pl.cinema.server.screening.query.domain.ScreeningReadEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
class ReservationEntity {

    @Id
    @GeneratedValue
    private Long id;
    private UUID uuid;
    private BigDecimal totalAmount;
    private String confirmationLink;
    private LocalDateTime expirationTime;
    private UUID reservationMakerId;

    //todo: such fields can be moved to abstract entity and shared between all entities if needed
    //but this may not be an issue. also @LastModifiedDate is a nice annotation for auditing, or hibernate Envers
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "screening_id")
    private ScreeningReadEntity screening;

    @OneToMany(fetch = LAZY)
    private List<ReservationScreeningSeatEntity> seats;


    Reservation toReservation() {
        return Reservation.builder()
                .amount(totalAmount)
                .confirmationLink(confirmationLink)
                .expirationTime(expirationTime)
                .selectedSeats(seats.stream().map(ReservationScreeningSeatEntity::toSeat).collect(toList()))
                .reservationMakerId(reservationMakerId)
                .build();
    }

    static ReservationEntity valueOf(Reservation reservation) {
        return ReservationEntity.builder()
                .totalAmount(reservation.getAmount())
                .expirationTime(reservation.getExpirationTime())
                .seats(reservation.getSelectedSeats().stream().map(ReservationScreeningSeatEntity::valueOf).collect(toList()))
                .reservationMakerId(reservation.getReservationMakerId())
                .confirmationLink(reservation.getConfirmationLink())
                .build();
    }


}
