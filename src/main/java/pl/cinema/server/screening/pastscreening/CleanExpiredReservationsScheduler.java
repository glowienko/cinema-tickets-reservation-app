package pl.cinema.server.screening.pastscreening;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class CleanExpiredReservationsScheduler implements ExpiredReservationsHandler {

    @Override
    @Scheduled(fixedDelay = 60000) //every minute
    public void cleanExpiredReservations() {
        //free reserved seats
        //mark reservation as expired

    }
}
