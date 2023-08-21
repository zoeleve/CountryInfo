import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {
    
	List<Continent> findAll();
	
}
