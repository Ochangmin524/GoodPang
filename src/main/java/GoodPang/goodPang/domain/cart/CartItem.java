package GoodPang.goodPang.domain.cart;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CartItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "item_id")
    private Item item; // 배송 상품

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Integer count; //상품 개수
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public void addCount(int count) {this.count += count;}
}
