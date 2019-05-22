package project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Gerecht;

import java.util.List;

@Repository
public interface GerechtRepository extends JpaRepository<Gerecht, Integer> {
    List<Gerecht> findByDescription(String description);
}
