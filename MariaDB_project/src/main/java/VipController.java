import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vips")
public class VipController {
    private final VipRepository vipRepository;

    @Autowired
    public VipController(VipRepository vipRepository) {
        this.vipRepository = vipRepository;
    }

    @GetMapping
    public List<vips> getAllVips() {
        return vipRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<vips> getVipById(@PathVariable int id) {
        Optional<vips> vip = vipRepository.findById(id);
        return vip.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public vips createVip(@RequestBody vips vip) {
        return vipRepository.save(vip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<vips> updateVip(@PathVariable int id, @RequestBody vips updatedVip) {
        if (!vipRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedVip.setVipId(id);
        vips savedVip = vipRepository.save(updatedVip);
        return ResponseEntity.ok(savedVip);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVip(@PathVariable int id) {
        vipRepository.deleteById(id);
    }
}
