package pl.cinema.server.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum VoucherStatus {
    NEW("NEW"),
    USED("USED");

    private final String status;

    @JsonCreator
    VoucherStatus fromType(String status) {
        return Arrays.stream(values())
                .filter(v -> v.getStatus().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
