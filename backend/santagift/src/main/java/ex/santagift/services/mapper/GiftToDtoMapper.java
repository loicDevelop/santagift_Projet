package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.services.dto.GiftDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftToDtoMapper implements ToDtoMapper<Gift, GiftDto> {

    @Autowired
    private UserToDtoResponseMapper userToDtoResponseMapper;

    public GiftDto toDto(Gift gift) {
        if (gift == null) {
            return null;
        }
        GiftDto giftDto = new GiftDto();
        giftDto.setId(gift.getId());
        giftDto.setName(gift.getName());
        giftDto.setUrl(gift.getUrl());
        giftDto.setPrix(gift.getPrix());
        giftDto.setImg(gift.getImg());
        giftDto.setUserIdWant(userToDtoResponseMapper.toDto(gift.getUserIdWant()));
        giftDto.setUserIdOffer(userToDtoResponseMapper.toDto(gift.getUserIdOffer()));
        return giftDto;
    }

    public List<GiftDto> toDto(List<Gift> list) {
        if (list == null) {
            return null;
        }
        List<GiftDto> gifts = new ArrayList<GiftDto>(list.size());
        for (Gift gift : list) {
            gifts.add(toDto(gift));
        }
        return gifts;
    }
}
