package com.tickets.reservationserver.screening.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ScreeningController {
//    private final ScreeningApiService screeningApiService;

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    String getHello() {
        return "Hello!";
    }

//    @GetMapping("/screenings")
//    List<AvailableScreeningDto> getAvailableScreenings(@RequestParam(name = "start") LocalDateTime startTimeRange,
//                                                       @RequestParam(name = "end") LocalDateTime endTimeRange) {
//        return screeningApiService.findScreenings(startTimeRange, endTimeRange);
//    }
//
//    @GetMapping("/screenings/{id}/details")
//    ScreeningDetailDto getScreeningDetails(@PathVariable Long id) {
//        return screeningApiService.getScreeningDetails(id);
//    }


}