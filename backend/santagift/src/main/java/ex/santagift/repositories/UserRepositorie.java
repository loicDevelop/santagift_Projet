package ex.santagift.repositories;

import ex.santagift.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<User, Long> {

}