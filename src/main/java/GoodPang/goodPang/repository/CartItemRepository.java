package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByItem(Item item);
}
