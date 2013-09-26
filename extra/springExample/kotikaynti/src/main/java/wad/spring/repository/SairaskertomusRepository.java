package wad.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Sairaskertomus;

public interface SairaskertomusRepository extends JpaRepository<Sairaskertomus, Long> {
}
