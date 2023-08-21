import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable int id, @RequestBody Country updatedCountry) {
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));

        // Update fields as needed
        existingCountry.setName(updatedCountry.getName());
        existingCountry.setArea(updatedCountry.getArea());

        return countryRepository.save(existingCountry);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));

        countryRepository.delete(country);
    }
}
