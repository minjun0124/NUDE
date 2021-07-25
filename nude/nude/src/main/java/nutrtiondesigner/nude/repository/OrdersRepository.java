package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select o from Orders o where o.user.id = :userId"
    , countQuery = "select count(o) from Orders o where o.user.id = :userId")
    Page<Orders> findByUserId(@Param("userId") Long userId, Pageable Pageable);
}
