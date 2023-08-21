import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continents")
public class ContinentController {
    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentController(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Continent getContinentById(@PathVariable int id) {
        return continentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found with id: " + id));
    }

    @PostMapping
    public Continent createContinent(@RequestBody Continent continent) {
        return continentRepository.save(continent);
    }

    @PutMapping("/{id}")
    public Continent updateContinent(@PathVariable int id, @RequestBody Continent updatedContinent) {
        Continent existingContinent = continentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found with id: " + id));

        existingContinent.setName(updatedContinent.getName());

        return continentRepository.save(existingContinent);
    }

    @DeleteMapping("/{id}")
    public void deleteContinent(@PathVariable int id) {
        Continent continent = continentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found with id: " + id));

        continentRepository.delete(continent);
    }
}
