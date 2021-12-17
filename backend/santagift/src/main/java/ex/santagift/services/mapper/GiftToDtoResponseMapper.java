package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.services.dto.GiftDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftToDtoResponseMapper implements ToDtoMapper<Gift, GiftDtoResponse> {

    public GiftDtoResponse toDto(Gift gift) {
        if (gift == null) {
            return null;
        }
        GiftDtoResponse giftDtoResponse = new GiftDtoResponse();
        giftDtoResponse.setId(gift.getId());
        giftDtoResponse.setName(gift.getName());
        giftDtoResponse.setUrl(gift.getUrl());
        giftDtoResponse.setPrix(gift.getPrix());
        giftDtoResponse.setImg(gift.getImg());
        return giftDtoResponse;
    }

    public List<GiftDtoResponse> toDto(List<Gift> list) {
        if (list == null) {
            return null;
        }
        List<GiftDtoResponse> gifts = new ArrayList<GiftDtoResponse>(list.size());
        for (Gift gift : list) {
            gifts.add(toDto(gift));
        }
        return gifts;
    }
}
