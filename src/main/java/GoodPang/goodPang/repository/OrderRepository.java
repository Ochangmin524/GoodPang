package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> getOrdersByMember(Member member);
}
