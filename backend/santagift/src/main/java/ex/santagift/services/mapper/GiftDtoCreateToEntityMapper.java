package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.services.dto.GiftDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftDtoCreateToEntityMapper implements ToEntityMapper<GiftDtoCreate, Gift> {

    @Autowired
    private UserDtoResponseToEntityMapper userDtoResponseToEntityMapper;

    public Gift toEntity(GiftDtoCreate giftDtoCreate) {
        if (giftDtoCreate == null) {
            return null;
        }
        Gift gift = new Gift();
        gift.setName(giftDtoCreate.getName());
        gift.setUrl(giftDtoCreate.getUrl());
        gift.setPrix(giftDtoCreate.getPrix());
        gift.setImg(giftDtoCreate.getImg());
        gift.setUserIdWant(userDtoResponseToEntityMapper.toEntity(giftDtoCreate.getUserIdWant()));
        gift.setUserIdOffer(userDtoResponseToEntityMapper.toEntity(giftDtoCreate.getUserIdOffer()));
        return gift;
    }

    public List<Gift> toEntity(List<GiftDtoCreate> list) {
        if (list == null) {
            return null;
        }
        List<Gift> gifts = new ArrayList<Gift>(list.size());
        for (GiftDtoCreate giftDtoCreate : list) {
            gifts.add(toEntity(giftDtoCreate));
        }
        return gifts;
    }
}