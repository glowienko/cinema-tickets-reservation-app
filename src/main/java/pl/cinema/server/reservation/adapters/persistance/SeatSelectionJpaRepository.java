package pl.cinema.server.reservation.adapters.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SeatSelectionJpaRepository extends JpaRepository<ReservationScreeningSeatEntity, Long> {

    List<ReservationScreeningSeatEntity> findAllByIdIsIn(List<Long> ids); //TODO: here probably UUID , and in query read model too
}
