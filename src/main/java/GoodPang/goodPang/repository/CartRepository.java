package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
