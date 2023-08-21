import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region-areas")
public class RegionAreaController {
    private final RegionAreaRepository regionAreaRepository;

    @Autowired
    public RegionAreaController(RegionAreaRepository regionAreaRepository) {
        this.regionAreaRepository = regionAreaRepository;
    }

    @GetMapping
    public List<RegionArea> getAllRegionAreas() {
        return regionAreaRepository.findAll();
    }

    @GetMapping("/{regionName}")
    public RegionArea getRegionAreaByName(@PathVariable String regionName) {
        return regionAreaRepository.findById(regionName)
                .orElseThrow(() -> new ResourceNotFoundException("RegionArea not found with name: " + regionName));
    }

    @PostMapping
    public RegionArea createRegionArea(@RequestBody RegionArea regionArea) {
        return regionAreaRepository.save(regionArea);
    }

    @PutMapping("/{regionName}")
    public RegionArea updateRegionArea(
            @PathVariable String regionName,
            @RequestBody RegionArea updatedRegionArea
    ) {
        RegionArea existingRegionArea = regionAreaRepository.findById(regionName)
                .orElseThrow(() -> new ResourceNotFoundException("RegionArea not found with name: " + regionName));

        existingRegionArea.setRegionArea(updatedRegionArea.getRegionArea());

        return regionAreaRepository.save(existingRegionArea);
    }

    @DeleteMapping("/{regionName}")
    public void deleteRegionArea(@PathVariable String regionName) {
        RegionArea regionArea = regionAreaRepository.findById(regionName)
                .orElseThrow(() -> new ResourceNotFoundException("RegionArea not found with name: " + regionName));

        regionAreaRepository.delete(regionArea);
    }
}
