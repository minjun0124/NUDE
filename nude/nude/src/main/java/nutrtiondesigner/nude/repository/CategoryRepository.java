package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
