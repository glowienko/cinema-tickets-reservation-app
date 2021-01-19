package pl.cinema.server.screening.pastscreening;

interface PastScreeningsCleaner {

    /**
     * Possibly some policy for removing old screenings that already took place
     */
    void removePastScreenings();
}
