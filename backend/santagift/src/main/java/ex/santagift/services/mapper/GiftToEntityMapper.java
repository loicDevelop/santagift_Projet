package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.services.dto.GiftDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftToEntityMapper implements ToEntityMapper<GiftDto, Gift> {

    @Autowired
    private UserDtoResponseToEntityMapper userDtoResponseToEntityMapper;

    public Gift toEntity(GiftDto giftDto) {
        if (giftDto == null) {
            return null;
        }
        Gift gift = new Gift();
        gift.setId(giftDto.getId());
        gift.setName(giftDto.getName());
        gift.setUrl(giftDto.getUrl());
        gift.setPrix(giftDto.getPrix());
        gift.setImg(giftDto.getImg());
        if( giftDto.getUserIdWant() != null) {
            gift.setUserIdWant(userDtoResponseToEntityMapper.toEntity(giftDto.getUserIdWant()));
        }
        if( giftDto.getUserIdOffer() != null) {
            gift.setUserIdOffer(userDtoResponseToEntityMapper.toEntity(giftDto.getUserIdOffer()));
        }
        return gift;
    }

    public List<Gift> toEntity(List<GiftDto> list) {
        if (list == null) {
            return null;
        }
        List<Gift> gifts = new ArrayList<Gift>(list.size());
        for (GiftDto giftDto : list) {
            gifts.add(toEntity(giftDto));
        }
        return gifts;
    }
}