package pl.cinema.server.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vouchers")
class Voucher {
    @Id
    private Long id;
    private String code;
    private double percentageDiscount;

    @Enumerated(STRING)
    private VoucherStatus status;

    @ManyToOne(fetch = LAZY)
    private Customer customer;
}
