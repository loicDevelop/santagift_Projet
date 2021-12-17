
package ex.santagift.services.mapper;

import ex.santagift.models.User;
import ex.santagift.repositories.UserRepositorie;
import ex.santagift.services.dto.UserDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDtoResponseToEntityMapper implements ToEntityMapper<UserDtoResponse, User> {

    @Autowired
    private UserRepositorie userRepositorie;

    public User toEntity(UserDtoResponse userDtoResponse) {
        if (userDtoResponse == null) {
            return null;
        }
        Optional<User> oUser = userRepositorie.findById(userDtoResponse.getId());
        User user = new User();
        if (oUser.isPresent()) {
            user = oUser.get();
        }
        user.setId(userDtoResponse.getId());
        user.setName(userDtoResponse.getName());
        user.setPseudo(userDtoResponse.getPseudo());
        user.setPassword(userDtoResponse.getPassword());
        return user;
    }

    public List<User> toEntity(List<UserDtoResponse> list) {
        if (list == null) {
            return null;
        }
        List<User> users = new ArrayList<User>(list.size());
        for (UserDtoResponse userDtoResponse : list) {
            users.add(toEntity(userDtoResponse));
        }
        return users;
    }
}
