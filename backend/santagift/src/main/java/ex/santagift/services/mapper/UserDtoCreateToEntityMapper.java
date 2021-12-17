package ex.santagift.services.mapper;

import ex.santagift.models.User;
import ex.santagift.services.dto.UserDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoCreateToEntityMapper implements ToEntityMapper<UserDtoCreate, User> {

    @Autowired
    private GiftDtoResponseToEntityMapper giftDtoResponseToEntityMapper;

    public User toEntity(UserDtoCreate userDtoCreate) {
        if (userDtoCreate == null) {
            return null;
        }
        User user = new User();
        user.setName(userDtoCreate.getName());
        user.setPseudo(userDtoCreate.getPseudo());
        user.setPassword(userDtoCreate.getPassword());
        if(userDtoCreate.getGifts() != null && userDtoCreate.getGifts().isEmpty()) {
            user.setGifts(giftDtoResponseToEntityMapper.toEntity(userDtoCreate.getGifts()));
        }
        return user;
    }

    public List<User> toEntity(List<UserDtoCreate> list) {
        if (list == null) {
            return null;
        }
        List<User> users = new ArrayList<User>(list.size());
        for (UserDtoCreate userDtoCreate : list) {
            users.add(toEntity(userDtoCreate));
        }
        return users;
    }
}
