package pl.cinema.server.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface VoucherJpaRepository extends JpaRepository<Voucher, Long> {
    Optional<Voucher> findByCodeAndStatus(String code, VoucherStatus status);
}
