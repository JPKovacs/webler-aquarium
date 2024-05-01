package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webleraquarium.entity.Fish;

import java.util.Optional;

public interface FishRepository extends JpaRepository<Fish, Long> {

    Optional<Fish> findByName(String name);

}
