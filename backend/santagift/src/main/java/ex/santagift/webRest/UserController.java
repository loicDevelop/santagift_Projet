package ex.santagift.webRest;

import ex.santagift.models.User;
import ex.santagift.services.UserServiceImplement;
import ex.santagift.services.dto.UserDto;
import ex.santagift.services.dto.UserDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImplement service;

    @GetMapping("")
    @ResponseBody
    public List<UserDto> getAll() {
        return this.service.getAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public UserDto getUserById(@PathVariable Long id) throws Exception {
        return this.service.findUserById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@RequestBody UserDtoCreate userDtoCreate) {
        return this.service.createUser(userDtoCreate);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserDto modifyUser(@RequestBody UserDto userDto) {
        return this.service.modifyUser(userDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) throws Exception {
        this.service.deleteUser(id);
    }
}