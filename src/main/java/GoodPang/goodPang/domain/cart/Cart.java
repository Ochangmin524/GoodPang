package GoodPang.goodPang.domain.cart;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CartItem> carts = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
    }

    public void addCartItem(CartItem cartItem) {
        carts.add(cartItem);
        cartItem.setCart(this);
    }


}
