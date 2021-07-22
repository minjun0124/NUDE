package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
