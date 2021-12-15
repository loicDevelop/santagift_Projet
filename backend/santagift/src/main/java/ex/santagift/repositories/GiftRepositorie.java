package ex.santagift.repositories;

import ex.santagift.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepositorie extends JpaRepository<Gift, Long> {

}
