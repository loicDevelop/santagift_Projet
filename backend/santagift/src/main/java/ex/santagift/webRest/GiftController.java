package ex.santagift.webRest;

import ex.santagift.models.Gift;
import ex.santagift.services.GiftServiceImplement;
import ex.santagift.services.dto.GiftDto;
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
    public GiftDto createGift(@RequestBody GiftDto giftDto) {
        return this.service.saveGift(giftDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGift(@PathVariable Long id) {
        this.service.delete(id);
    }
}