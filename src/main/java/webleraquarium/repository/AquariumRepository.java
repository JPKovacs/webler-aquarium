package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webleraquarium.entity.Aquarium;

import java.util.Optional;

public interface AquariumRepository extends JpaRepository<Aquarium, Long> {

    Optional<Aquarium> findBySize(Double size);

}
