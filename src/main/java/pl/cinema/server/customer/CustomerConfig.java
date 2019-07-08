package pl.cinema.server.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomerConfig {

    @Bean
    CustomerFacade customerFacade(VoucherJpaRepository repository, CustomerJpaRepository customerJpaRepository) {
        return new CustomerFacade(repository, customerJpaRepository);
    }
}
