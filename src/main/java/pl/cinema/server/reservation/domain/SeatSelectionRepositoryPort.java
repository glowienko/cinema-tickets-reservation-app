package pl.cinema.server.reservation.domain;

import java.util.List;

public interface SeatSelectionRepositoryPort {

    List<SelectedSeat> findAllByIdIsIn(List<Long> ids);
}
