package ex.santagift.services.mapper;

import ex.santagift.models.User;
import ex.santagift.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToEntityMapper implements ToEntityMapper<UserDto, User> {

    @Autowired
    private GiftToEntityMapper giftToEntityMapper;

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPseudo(userDto.getPseudo());
        user.setPassword(userDto.getPassword());
        user.setGifts(giftToEntityMapper.toEntity(userDto.getGifts()));

        return user;
    }

    public List<User> toEntity(List<UserDto> list) {
        if (list == null) {
            return null;
        }
        List<User> users = new ArrayList<User>(list.size());
        for (ex.santagift.services.dto.UserDto userDto : list) {
            users.add(toEntity(userDto));
        }
        return users;
    }
}
