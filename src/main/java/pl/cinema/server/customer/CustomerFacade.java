package pl.cinema.server.customer;

import lombok.RequiredArgsConstructor;
import pl.cinema.server.customer.dto.CustomerDto;

@RequiredArgsConstructor
public class CustomerFacade {
    private final VoucherJpaRepository voucherRepo;
    private final CustomerJpaRepository customerRepo;

    public Long createIfNotExists(CustomerDto dto) {
        return CustomerDto.builder().id(1L).build().getId();
    }

    public double getVoucherDiscount(String code) {
        return voucherRepo.findByCodeAndStatus(code, VoucherStatus.NEW)
                .map(Voucher::getPercentageDiscount)
                .orElseThrow(IllegalArgumentException::new);
    }

    public CustomerDto findCustomer(Long id) {
        return customerRepo.findById(id)
                .map(Customer::toCustomerDto)
                .orElseThrow(IllegalStateException::new);
    }
}
