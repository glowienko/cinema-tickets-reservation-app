package pl.cinema.server.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cinema.server.customer.CustomerFacade;
import pl.cinema.server.customer.dto.CustomerDto;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static pl.cinema.server.reservation.TicketType.STUDENT;

@Component
@RequiredArgsConstructor
class StudentPriceEvaluator implements PriceEvaluator {
    private final CustomerFacade customerFacade;

    public Price evaluatePrice(String voucherCode) {
        BigDecimal voucherDiscount = valueOf(customerFacade.getVoucherDiscount(voucherCode) / 100);

        return new Price(valueOf(STUDENT.getPrice()).multiply(voucherDiscount));
    }

    public boolean canHandle(Long customerId) {
        CustomerDto customer = customerFacade.findCustomer(customerId);

        return customer.getIsStudent();
    }


}
