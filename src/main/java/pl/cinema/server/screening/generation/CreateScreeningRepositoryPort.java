package pl.cinema.server.screening.generation;

interface CreateScreeningRepositoryPort {

    NewScreeningEntity save(NewScreeningEntity entity);
}
