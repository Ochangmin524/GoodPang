package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
