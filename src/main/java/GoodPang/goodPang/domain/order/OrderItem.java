package GoodPang.goodPang.domain.order;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item; //주문 상품


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order; //주문


    private Integer orderPrice; // 주문 가격

    private Integer count; //주문 수량

    public void setOrders(Orders orders) {
        this.order = orders;
    }
}
