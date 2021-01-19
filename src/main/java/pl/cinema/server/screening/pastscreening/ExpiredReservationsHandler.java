package pl.cinema.server.screening.pastscreening;

interface ExpiredReservationsHandler {

    /**
     * Some policy should implement this and it should remove not confirmed reservations when 15 min before screening
     */
    void cleanExpiredReservations();
}
