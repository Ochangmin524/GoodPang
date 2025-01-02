package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.member.Member;

import java.util.ArrayList;

public class CartConverter {

    public static Cart toCart(Member member) {
        return Cart.builder()
                .member(member)
                .carts(new ArrayList<>())
                .build();
    }
}
