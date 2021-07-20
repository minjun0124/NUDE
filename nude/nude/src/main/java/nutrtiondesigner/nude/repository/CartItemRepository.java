package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Answer;
import nutrtiondesigner.nude.model.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
