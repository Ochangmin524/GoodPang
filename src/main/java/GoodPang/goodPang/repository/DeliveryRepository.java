package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.order.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
