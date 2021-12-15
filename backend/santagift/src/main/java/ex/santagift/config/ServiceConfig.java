package ex.santagift.config;

import ex.santagift.repositories.GiftRepositorie;
import ex.santagift.repositories.UserRepositorie;
import ex.santagift.services.GiftServiceImplement;
import ex.santagift.services.UserServiceImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public UserServiceImplement userServiceImplement(UserRepositorie repository) {
        return new UserServiceImplement(repository);
    }

    @Bean
    public GiftServiceImplement giftServiceImplement(GiftRepositorie repository) {
        return new GiftServiceImplement(repository);
    }

}
