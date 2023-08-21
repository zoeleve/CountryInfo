import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    private final RegionRepository regionRepository;

    @Autowired
    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable int id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
    }

    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return regionRepository.save(region);
    }

    @PutMapping("/{id}")
    public Region updateRegion(@PathVariable int id, @RequestBody Region updatedRegion) {
        Region existingRegion = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));

        existingRegion.setName(updatedRegion.getName());

        return regionRepository.save(existingRegion);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable int id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));

        regionRepository.delete(region);
    }
}
