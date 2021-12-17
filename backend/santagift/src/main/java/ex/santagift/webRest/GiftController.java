package ex.santagift.webRest;

import ex.santagift.models.Gift;
import ex.santagift.models.User;
import ex.santagift.services.GiftServiceImplement;
import ex.santagift.services.dto.GiftDto;
import ex.santagift.services.dto.GiftDtoCreate;
import ex.santagift.services.dto.UserDto;
import ex.santagift.services.dto.UserDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gifts")
@CrossOrigin
public class GiftController {

    @Autowired
    private GiftServiceImplement service;

    @GetMapping("")
    @ResponseBody
    public List<GiftDto> getAll() {
        return this.service.getAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public GiftDto getGiftById(@PathVariable Long id) throws Exception {
        return this.service.findGiftById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Gift createGift(@RequestBody GiftDtoCreate giftDtoCreate) {
        return this.service.createGift(giftDtoCreate);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GiftDto modifyGift(@RequestBody GiftDto giftDto) {
        return this.service.modifyGift(giftDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGift(@PathVariable Long id) throws Exception {
        this.service.deleteGift(id);
    }
}