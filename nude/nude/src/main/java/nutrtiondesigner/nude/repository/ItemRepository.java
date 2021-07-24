package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.CategoryItem;
import nutrtiondesigner.nude.model.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select ci from CategoryItem ci join fetch ci.item where ci.category.code = :category_code"
    , countQuery = "select count(ci) from CategoryItem ci where ci.category.code = :category_code")
    Page<CategoryItem> findByCategory(@Param("category_code") Long categoryCode, Pageable pageable);

}
