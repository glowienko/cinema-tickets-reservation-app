package pl.cinema.server.reservation.domain;

import java.util.Optional;
import java.util.UUID;

public interface ReservationRepositoryPort {

    Reservation save(Reservation reservation);
    Optional<Reservation> findByUuid(UUID id);
}
