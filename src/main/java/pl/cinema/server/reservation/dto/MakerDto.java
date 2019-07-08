package pl.cinema.server.reservation.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MakerDto {
    String name;
    String surname;
    Long age;
    String voucherCode;
}
