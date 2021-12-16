package ex.santagift.services;

import ex.santagift.models.User;
import ex.santagift.repositories.UserRepositorie;
import ex.santagift.services.dto.UserDto;
import ex.santagift.services.mapper.UserToDtoMapper;
import ex.santagift.services.mapper.UserToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class UserServiceImplement extends GenericServiceImplement<User> {

    @Autowired
    private UserRepositorie repositorie;

    @Autowired
    private UserToEntityMapper userToEntityMapper;

    @Autowired
    private UserToDtoMapper userToDtoMapper;

    public UserServiceImplement(JpaRepository<User, Long> repository) {
        super(repository);
    }

    public UserDto findUserById(Long id) throws Exception {
        Optional<User> oUser = repositorie.findById(id);
        if (!oUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = oUser.get();
        return userToDtoMapper.toDto(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userToEntityMapper.toEntity(userDto);
        repositorie.save(user);
        return userToDtoMapper.toDto(user);
    }

    public List<UserDto> getAll() {
        return userToDtoMapper.toDto(repositorie.findAll());
    }
}