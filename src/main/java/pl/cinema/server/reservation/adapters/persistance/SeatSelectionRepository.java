package pl.cinema.server.reservation.adapters.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cinema.server.reservation.domain.SeatSelectionRepositoryPort;
import pl.cinema.server.reservation.domain.SelectedSeat;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class SeatSelectionRepository implements SeatSelectionRepositoryPort {
    private final SeatSelectionJpaRepository screeningJpaRepository;

    @Override
    public List<SelectedSeat> findAllByIdIsIn(List<Long> ids) {
        return screeningJpaRepository.findAllByIdIsIn(ids)
                .stream()
                .map(ReservationScreeningSeatEntity::toSeat)
                .collect(Collectors.toList());
    }
}