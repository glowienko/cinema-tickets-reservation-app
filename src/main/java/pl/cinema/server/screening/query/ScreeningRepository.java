package pl.cinema.server.screening.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RequiredArgsConstructor
class ScreeningRepository implements ScreeningRepositoryPort {
    private final ScreeningJpaRepository screeningJpaRepository;

    @Override
    public List<ScreeningQuery> getAvailableScreenings(LocalDateTime start, LocalDateTime end) {
        return screeningJpaRepository.findAllByStartAfterAndEndBefore(start, end, new Sort(DESC, List.of("movieTitle","start")));
    }

    public Optional<ScreeningQuery> getScreeningDetails(Long id) {
        return screeningJpaRepository.findAll()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst(); //todo: fix this, use normal find by id
    }

}