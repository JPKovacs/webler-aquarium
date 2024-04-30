package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webleraquarium.entity.Aquarium;

public interface AquariumRepository extends JpaRepository<Aquarium, Long> {

}
