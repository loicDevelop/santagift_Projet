
package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.models.User;
import ex.santagift.repositories.GiftRepositorie;
import ex.santagift.services.dto.GiftDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GiftDtoResponseToEntityMapper implements ToEntityMapper<GiftDtoResponse, Gift> {

    @Autowired
    private GiftRepositorie giftRepositorie;

    public Gift toEntity(GiftDtoResponse giftDtoResponse) {
        if (giftDtoResponse == null) {
            return null;
        }
        Optional<Gift> oGift = giftRepositorie.findById(giftDtoResponse.getId());
        Gift gift = new Gift();
        if (oGift.isPresent()) {
            gift = oGift.get();
        }
        gift.setId(giftDtoResponse.getId());
        gift.setName(giftDtoResponse.getName());
        gift.setUrl(giftDtoResponse.getUrl());
        gift.setPrix(giftDtoResponse.getPrix());
        gift.setImg(giftDtoResponse.getImg());
        return gift;
    }

    public List<Gift> toEntity(List<GiftDtoResponse> list) {
        if (list == null) {
            return null;
        }
        List<Gift> gifts = new ArrayList<Gift>(list.size());
        for (GiftDtoResponse giftDtoResponse : list) {
            gifts.add(toEntity(giftDtoResponse));
        }
        return gifts;
    }
}