package ex.santagift.services;

import ex.santagift.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public class GiftServiceImplement extends GenericServiceImplement<Gift> {

    public GiftServiceImplement(JpaRepository<Gift, Long> repository) {
        super(repository);
    }
}