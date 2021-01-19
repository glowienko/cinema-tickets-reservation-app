package pl.cinema.server.screening.generation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

interface ScreeningGenerator {

    NewScreeningEntity generateScreening(MovieEntity movie, RoomEntity roomEntity, LocalDateTime startTime);


    List<NewScreeningEntity> generateScreeningsInFreeRoomsForTimeRange(MovieEntity movie, PartOfDay partOfDay, LocalDate startDay, LocalDate endDate);

    //todo: here probably would be nice to have screening generation for eg. whole week? or for whole week in every evening?
    //or some screening creation for movie, everyday, after/before  some hour in a free rooms?  !
}
