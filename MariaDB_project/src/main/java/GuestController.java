import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @GetMapping("/{guestId}")
    public Guest getGuestById(@PathVariable int guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @PutMapping("/{guestId}")
    public Guest updateGuest(@PathVariable int guestId, @RequestBody Guest updatedGuest) {
        Guest existingGuest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));

        existingGuest.setName(updatedGuest.getName());

        return guestRepository.save(existingGuest);
    }

    @DeleteMapping("/{guestId}")
    public void deleteGuest(@PathVariable int guestId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));

        guestRepository.delete(guest);
    }
}
