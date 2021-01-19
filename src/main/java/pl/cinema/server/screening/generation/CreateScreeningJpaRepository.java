package pl.cinema.server.screening.generation;

import org.springframework.data.jpa.repository.JpaRepository;

interface CreateScreeningJpaRepository extends JpaRepository<NewScreeningEntity, Long> {
}
