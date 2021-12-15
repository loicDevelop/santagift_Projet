package ex.santagift.webRest;

import ex.santagift.models.Gift;
import ex.santagift.services.GiftServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gifts")
@CrossOrigin
public class GiftController {

    @Autowired
    private GiftServiceImplement service;

    @GetMapping("")
    public List<Gift> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Gift findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping("")
    public Gift save(@RequestBody Gift gift) {
        return this.service.save(gift);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}