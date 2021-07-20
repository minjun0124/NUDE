package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long> {
}
