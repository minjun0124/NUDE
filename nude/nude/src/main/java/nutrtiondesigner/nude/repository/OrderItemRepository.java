package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query(value = "select oi from OrderItem oi join fetch oi.item where oi.orders.code = :orderItemCode"
    , countQuery = "select oi from OrderItem oi where oi.orders.code = :orderItemCode")
    Page<OrderItem> findFetchJoinByOrderCode(@Param("orderItemCode") Long orderItemCode, Pageable pageable);
}
