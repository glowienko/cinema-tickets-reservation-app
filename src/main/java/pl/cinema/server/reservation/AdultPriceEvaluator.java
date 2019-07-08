package pl.cinema.server.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cinema.server.customer.CustomerFacade;
import pl.cinema.server.customer.dto.CustomerDto;

import java.math.BigDecimal;

import static pl.cinema.server.reservation.TicketType.ADULT;

@Component
@RequiredArgsConstructor
class AdultPriceEvaluator implements PriceEvaluator {
    private final CustomerFacade customerFacade;

    public Price evaluatePrice(String voucherCode) {
        double voucherDiscount = customerFacade.getVoucherDiscount(voucherCode) / 100;

        return new Price(BigDecimal.valueOf(ADULT.getPrice() * voucherDiscount));
    }

    public boolean canHandle(Long customerId) {
        CustomerDto customer = customerFacade.findCustomer(customerId);
        return customer.getAge() >= 18 && !customer.getIsStudent();
    }


}
