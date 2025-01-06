package GoodPang.goodPang.domain.order;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.enums.OrderStatus;
import GoodPang.goodPang.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>(); // 배송 상품


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; //배송정보


    private LocalDateTime orderDate; // 주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER,CANCEL]


    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrders(this);
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrders(this);
    }
}
