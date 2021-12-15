package ex.santagift.webRest;

import ex.santagift.models.User;
import ex.santagift.services.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImplement service;

    @GetMapping("")
    public List<User> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        return this.service.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}