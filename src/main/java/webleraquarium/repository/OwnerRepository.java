package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webleraquarium.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
