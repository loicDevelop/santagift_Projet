package ex.santagift.webRest;

import ex.santagift.services.UserServiceImplement;
import ex.santagift.services.dto.UserDto;
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
    public UserDto createUser(@RequestBody UserDto userDto) {
        return this.service.saveUser(userDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        this.service.delete(id);
    }
}