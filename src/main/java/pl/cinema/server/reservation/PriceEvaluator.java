package pl.cinema.server.reservation;

interface PriceEvaluator {
    Price evaluatePrice(String voucherCode);

    boolean canHandle(Long customerId);

}
