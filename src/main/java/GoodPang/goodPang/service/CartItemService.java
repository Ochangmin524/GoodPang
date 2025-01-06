package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.CartItemConverter;
import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.CartItemRepository;
import GoodPang.goodPang.repository.ItemRepository;

import GoodPang.goodPang.repository.MemberRepository;
import GoodPang.goodPang.response.exception.handler.CartHandler;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.CartItemRequestDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemService {
    private final MemberRepository memberRepository;
    private final CartItemRepository cartItemRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public CartItem addCartItem(CartItemRequestDto.AddCartItem request) {
        //상품 조회
        Item item = itemRepository.findById(request.getItemId()).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));
        //회원 조회
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
        //장바구니 조회
        Cart cart = member.getCart();

        //만약 장바구니에 이미 존재하는 거면 , 수량만 더하기
        Boolean isExist = false;

        for (CartItem cartItem : cart.getCarts()) {
            if(cartItem.getItem() == item) {
                isExist = true;
                if ( cartItem.getCount() + request.getCount() > item.getStockQuantity()) {
                    throw new CartHandler(ErrorStatus._OVER_ITEM_STOCK);
                } else {
                    cartItem.addCount(request.getCount());
                }
                return cartItem;
            }
        }
        //장바구니에 없는 상품이면, 생성
        if (!isExist) {
            //상품 제고 오류 처리
            if (item.getStockQuantity() < request.getCount()) {
                throw new CartHandler(ErrorStatus._OVER_ITEM_STOCK);
            }
            //장바구니 상품 생성
            CartItem cartItem = CartItemConverter.toCartItem(request, item);
            //연관관계 매핑
            cart.addCartItem(cartItem);

            return cartItemRepository.save(cartItem);
        }

        //
        return null;
    }

}
