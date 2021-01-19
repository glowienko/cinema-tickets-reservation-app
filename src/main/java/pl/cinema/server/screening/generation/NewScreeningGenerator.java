package pl.cinema.server.screening.generation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static pl.cinema.server.screening.generation.FreeSeatStatus.FREE;

@Component
@RequiredArgsConstructor
public class NewScreeningGenerator implements ScreeningGenerator {

    private final CreateScreeningRepositoryPort screeningRepositoryPort;

    @Override
    public NewScreeningEntity generateScreening(MovieEntity movie, RoomEntity roomEntity, LocalDateTime startTime) {
        NewScreeningEntity newScreeningEntity = NewScreeningEntity.builder()
                .movieTitle(movie.getTitle())
                .startTime(startTime)
                .endTime(startTime.plusMinutes(movie.getLength().toMinutes()))
                .roomName(roomEntity.getName())
                .build();

        newScreeningEntity.setSeats(roomEntity.getSeats()
                .stream()
                .map(s -> new NewScreeningSeatEntity(null, FREE, s.getRow(), s.getNumber(), newScreeningEntity))
                .collect(Collectors.toList()));

        return screeningRepositoryPort.save(newScreeningEntity);
    }

    @Override
    public List<NewScreeningEntity> generateScreeningsInFreeRoomsForTimeRange(MovieEntity movie, PartOfDay partOfDay, LocalDate startDay, LocalDate endDate) {
        return null;
    }
}
