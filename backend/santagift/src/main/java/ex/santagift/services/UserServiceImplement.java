package ex.santagift.services;

import ex.santagift.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserServiceImplement extends GenericServiceImplement<User> {

    public UserServiceImplement(JpaRepository<User, Long> repository) {
        super(repository);
    }
}