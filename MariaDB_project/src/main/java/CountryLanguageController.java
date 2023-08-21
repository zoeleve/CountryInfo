import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country-languages")
public class CountryLanguageController {
    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public CountryLanguageController(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @GetMapping
    public List<CountryLanguage> getAllCountryLanguages() {
        return countryLanguageRepository.findAll();
    }

    @GetMapping("/{countryId}/{languageId}")
    public CountryLanguage getCountryLanguageById(@PathVariable int countryId, @PathVariable int languageId) {
        CountryLanguageId id = new CountryLanguageId(countryId, languageId);
        return countryLanguageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryLanguage not found with id: " + id));
    }

    @PostMapping
    public CountryLanguage createCountryLanguage(@RequestBody CountryLanguage countryLanguage) {
        return countryLanguageRepository.save(countryLanguage);
    }

    @PutMapping("/{countryId}/{languageId}")
    public CountryLanguage updateCountryLanguage(
            @PathVariable int countryId,
            @PathVariable int languageId,
            @RequestBody CountryLanguage updatedCountryLanguage
    ) {
        CountryLanguageId id = new CountryLanguageId(countryId, languageId);
        CountryLanguage existingCountryLanguage = countryLanguageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryLanguage not found with id: " + id));

        existingCountryLanguage.setOfficial(updatedCountryLanguage.isOfficial());

        return countryLanguageRepository.save(existingCountryLanguage);
    }

    @DeleteMapping("/{countryId}/{languageId}")
    public void deleteCountryLanguage(@PathVariable int countryId, @PathVariable int languageId) {
        CountryLanguageId id = new CountryLanguageId(countryId, languageId);
        CountryLanguage countryLanguage = countryLanguageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CountryLanguage not found with id: " + id));

        countryLanguageRepository.delete(countryLanguage);
    }
}
