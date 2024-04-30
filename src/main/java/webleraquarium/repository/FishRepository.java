package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webleraquarium.entity.Fish;

public interface FishRepository extends JpaRepository<Fish, Long> {

}
