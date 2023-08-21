import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable int id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageRepository.save(language);
    }

    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable int id, @RequestBody Language updatedLanguage) {
        Language existingLanguage = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        existingLanguage.setLanguage(updatedLanguage.getLanguage());

        return languageRepository.save(existingLanguage);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable int id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        languageRepository.delete(language);
    }
}
