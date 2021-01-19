package pl.cinema.server.reservation.adapters.api;


import lombok.RequiredArgsConstructor;
import pl.cinema.server.reservation.adapters.api.dto.ReservationCommand;
import pl.cinema.server.reservation.adapters.api.dto.ReservationConfirmationDto;
import pl.cinema.server.reservation.adapters.api.dto.ReservationMakerDto;
import pl.cinema.server.reservation.adapters.api.dto.ScreeningSeatDto;
import pl.cinema.server.reservation.domain.Reservation;
import pl.cinema.server.reservation.domain.ReservationService;
import pl.cinema.server.reservation.domain.SelectedSeat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
class ReservationApiService {
    private final ReservationService reservationService;

    ReservationConfirmationDto makeReservation(ReservationCommand reservationCommand) {
        ReservationMakerDto maker = reservationCommand.getMaker();
        List<SelectedSeat> selectedSeats = reservationCommand.getSelectedSeats().stream().map(ScreeningSeatDto::toSelectedSeat).collect(toList());
        LocalDateTime screeningStartTime = reservationCommand.getScreeningStartTime();

        Reservation reservation = reservationService.makeReservation(maker, selectedSeats, screeningStartTime);
        return ReservationConfirmationDto.valueOf(reservation);
    }

    boolean confirmReservation(UUID reservationId) {
        return reservationService.confirmReservation(reservationId);
    }


}
