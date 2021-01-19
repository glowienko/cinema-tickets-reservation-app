package pl.cinema.server.reservation.adapters.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cinema.server.reservation.domain.Reservation;
import pl.cinema.server.reservation.domain.ReservationRepositoryPort;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class ReservationRepository implements ReservationRepositoryPort {
    private final ReservationJpaRepository reservationJpaRepository;

    public Reservation save(Reservation reservation) {
        ReservationEntity result = reservationJpaRepository.save(ReservationEntity.valueOf(reservation));
        return result.toReservation();
    }

    public Optional<Reservation> findByUuid(UUID uuid) {
        return reservationJpaRepository.findByUuid(uuid)
                .map(ReservationEntity::toReservation);
    }

}