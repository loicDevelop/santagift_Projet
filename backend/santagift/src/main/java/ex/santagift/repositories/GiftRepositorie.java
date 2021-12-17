package ex.santagift.repositories;

import ex.santagift.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftRepositorie extends JpaRepository<Gift, Long> {

    @Query("SELECT * FROM gift WHERE userIdWant = :userIdWant")
    List<Gift> findAllByUserId(@Param("userIdWant") Long id);
}
