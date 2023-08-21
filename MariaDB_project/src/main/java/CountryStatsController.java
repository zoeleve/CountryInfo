import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country-stats")
public class CountryStatsController {
    private final CountryStatsRepository countryStatsRepository;

    @Autowired
    public CountryStatsController(CountryStatsRepository countryStatsRepository) {
        this.countryStatsRepository = countryStatsRepository;
    }

    @GetMapping
    public List<CountryStats> getAllCountryStats() {
        return countryStatsRepository.findAll();
    }

    @GetMapping("/{countryId}/{year}")
    public CountryStats getCountryStatsById(@PathVariable int countryId, @PathVariable int year) {
        CountryStatsId id = new CountryStatsId();
        id.setYear(year);

        return countryStatsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryStats not found with id: " + id));
    }

    @PostMapping
    public CountryStats createCountryStats(@RequestBody CountryStats countryStats) {
        return countryStatsRepository.save(countryStats);
    }

    @PutMapping("/{countryId}/{year}")
    public CountryStats updateCountryStats(
            @PathVariable int countryId,
            @PathVariable int year,
            @RequestBody CountryStats updatedCountryStats
    ) {
        CountryStatsId id = new CountryStatsId();
        id.setYear(year);

        CountryStats existingCountryStats = countryStatsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryStats not found with id: " + id));

        // Update fields as needed
        existingCountryStats.setPopulation(updatedCountryStats.getPopulation());
        existingCountryStats.setGdp(updatedCountryStats.getGdp());
        // ... (update other fields)

        return countryStatsRepository.save(existingCountryStats);
    }

    @DeleteMapping("/{countryId}/{year}")
    public void deleteCountryStats(@PathVariable int countryId, @PathVariable int year) {
        CountryStatsId id = new CountryStatsId();
        id.setYear(year);

        CountryStats countryStats = countryStatsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryStats not found with id: " + id));

        countryStatsRepository.delete(countryStats);
    }
}
