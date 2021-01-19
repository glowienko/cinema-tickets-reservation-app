package pl.cinema.server.screening.query.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum SeatStatus {
    @JsonProperty("Wolne")
    FREE,
    @JsonProperty("Zarezerwowane")
    RESERVED,
    @JsonProperty("Zajęte")
    TAKEN
}
