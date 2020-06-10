package lt.web.demo.repositories;

import java.math.BigDecimal;

import lt.web.demo.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> getAllByItemValue(BigDecimal itemValue, Pageable pageable);

}