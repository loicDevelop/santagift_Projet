package ex.santagift.services;

import ex.santagift.models.Gift;
import ex.santagift.repositories.GiftRepositorie;
import ex.santagift.services.dto.GiftDto;
import ex.santagift.services.mapper.GiftToDtoMapper;
import ex.santagift.services.mapper.GiftToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class GiftServiceImplement extends GenericServiceImplement<Gift> {

    @Autowired
    private GiftRepositorie repositorie;

    @Autowired
    private GiftToEntityMapper giftToEntityMapper;

    @Autowired
    private GiftToDtoMapper giftToDtoMapper;

    public GiftServiceImplement(JpaRepository<Gift, Long> repository) {
        super(repository);
    }

    public GiftDto findGiftById(Long id) throws Exception {
        Optional<Gift> oGift = repositorie.findById(id);
        if (!oGift.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Gift gift = oGift.get();
        return giftToDtoMapper.toDto(gift);
    }

    public GiftDto saveGift(GiftDto giftDto) {
        Gift gift = giftToEntityMapper.toEntity(giftDto);
        repositorie.save(gift);
        return giftToDtoMapper.toDto(gift);
    }

    public List<GiftDto> getAll() {
        return giftToDtoMapper.toDto(repositorie.findAll());
    }
}