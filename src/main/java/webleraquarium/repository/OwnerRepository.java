package webleraquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webleraquarium.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
