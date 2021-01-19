package pl.cinema.server.screening.generation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CreateScreeningRepository implements CreateScreeningRepositoryPort {
    private final CreateScreeningJpaRepository screeningJpaRepository;

    public NewScreeningEntity save(NewScreeningEntity entity) {
        return screeningJpaRepository.save(entity);
    }
}