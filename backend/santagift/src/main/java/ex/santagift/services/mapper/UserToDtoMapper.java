package ex.santagift.services.mapper;

import ex.santagift.models.Gift;
import ex.santagift.models.User;
import ex.santagift.repositories.GiftRepositorie;
import ex.santagift.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToDtoMapper implements ToDtoMapper<User, UserDto> {

    @Autowired
    private GiftRepositorie giftRepositorie;

    @Autowired
    private GiftToDtoResponseMapper giftToDtoResponseMapper;

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPseudo(user.getPseudo());
        userDto.setPassword(user.getPassword());
        List<Gift> gifts = mapGift(user.getId());
        if(gifts.size() >= 1) {
            userDto.setGifts(giftToDtoResponseMapper.toDto(user.getGifts()));
        }
        return userDto;
    }

    public List<UserDto> toDto(List<User> list) {
        if (list == null) {
            return null;
        }
        List<UserDto> users = new ArrayList<ex.santagift.services.dto.UserDto>(list.size());
        for (User user : list) {
            users.add(toDto(user));
        }
        return users;
    }

    private List<Gift> mapGift(Long idUser){
        return giftRepositorie.findAllByUserId(idUser);
    }
}
