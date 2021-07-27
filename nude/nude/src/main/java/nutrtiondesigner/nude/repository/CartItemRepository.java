package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Answer;
import nutrtiondesigner.nude.model.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartCodeAndItemCode(Long cartcode, Long itemcode);

}
