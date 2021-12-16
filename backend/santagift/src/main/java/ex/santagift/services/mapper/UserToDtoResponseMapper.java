package ex.santagift.services.mapper;

import ex.santagift.models.User;
import ex.santagift.services.dto.UserDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToDtoResponseMapper implements ToDtoMapper<User, UserDtoResponse> {

    @Autowired
    private GiftToDtoMapper giftToDtoMapper;

    public UserDtoResponse toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setId(user.getId());
        userDtoResponse.setName(user.getName());
        userDtoResponse.setPseudo(user.getPseudo());
        userDtoResponse.setPassword(user.getPassword());
        return userDtoResponse;
    }

    public List<UserDtoResponse> toDto(List<User> list) {
        if (list == null) {
            return null;
        }
        List<UserDtoResponse> users = new ArrayList<UserDtoResponse>(list.size());
        for (User user : list) {
            users.add(toDto(user));
        }
        return users;
    }
}
