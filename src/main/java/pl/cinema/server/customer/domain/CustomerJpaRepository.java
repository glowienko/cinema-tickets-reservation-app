package pl.cinema.server.customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
