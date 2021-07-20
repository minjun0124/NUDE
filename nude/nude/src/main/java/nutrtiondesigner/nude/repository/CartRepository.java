package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Cart;
import nutrtiondesigner.nude.model.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
