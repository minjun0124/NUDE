package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
