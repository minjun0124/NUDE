package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.OrderItem;
import nutrtiondesigner.nude.model.domain.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("select oi from OrderItem oi join fetch Item where oi.orders.code = :orderItemCode")
    Page<OrderItem> findFetchJoinByOrderCode(@Param("orderItemCode") Long orderItemCode, Pageable pageable);
}
