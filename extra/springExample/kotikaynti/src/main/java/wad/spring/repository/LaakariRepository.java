package wad.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Laakari;

public interface LaakariRepository extends JpaRepository<Laakari, Long> {
}
