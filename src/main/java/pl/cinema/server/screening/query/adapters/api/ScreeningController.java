package pl.cinema.server.screening.query.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.cinema.server.screening.query.adapters.api.dto.AvailableScreeningDto;
import pl.cinema.server.screening.query.adapters.api.dto.ScreeningDetailDto;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
class ScreeningController {
    private final ScreeningApiService screeningApiService;

    @GetMapping("/screenings")
    List<AvailableScreeningDto> getAvailableScreenings(@RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTimeRange,
                                                       @RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTimeRange) {
        return screeningApiService.findScreenings(startTimeRange, endTimeRange);
    }

    @GetMapping("/screenings/{id}/details")
    ScreeningDetailDto getScreeningDetails(@PathVariable Long id) {
        return screeningApiService.getScreeningDetails(id);
    }


}
