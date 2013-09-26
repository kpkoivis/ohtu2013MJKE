package wad.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Viite;

public interface ViiteRepository extends JpaRepository<Viite, Long> {
}
