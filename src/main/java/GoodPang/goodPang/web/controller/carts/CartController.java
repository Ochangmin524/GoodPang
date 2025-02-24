package GoodPang.goodPang.web.controller.carts;

import GoodPang.goodPang.api.dto.CartItemRequestDto;
import GoodPang.goodPang.api.dto.MemberResponseDto;
import GoodPang.goodPang.converter.CartItemConverter;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.service.CartItemService;
import GoodPang.goodPang.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartItemService cartItemService;
    private final MemberService memberService;
    @PostMapping("/addCart")
    public String addCart(@ModelAttribute("addCartForm") CartItemRequestDto.AddCartItem request) {
        try {
            cartItemService.addCartItem(request);
        }catch (Exception e){
            return "redirect:/carts";
        }
      //장바구니에 상품 더하기
        return "redirect:/carts";
    }
    @DeleteMapping("/cartItems/{cartItemId}")
    public String deleteCartItem(@PathVariable("cartItemId") Long cartItemId) {
        MemberResponseDto.GetMemberResultDTO memberDtoByLoginId = memberService.getMemberDtoByLoginId();
        Long memberId = memberDtoByLoginId.getMemberId();
        CartItemRequestDto.DeleteCartItem request = new CartItemRequestDto.DeleteCartItem();
        request.setCartItemId(cartItemId);
        request.setCartId(memberId);
        cartItemService.deleteCartItem(request);
        return "redirect:/carts";
    }

    @GetMapping("/carts")
    public String getCarts(Model model) {
        MemberResponseDto.GetMemberResultDTO memberDtoByLoginId = memberService.getMemberDtoByLoginId();
        List<CartItem> cartItems = cartItemService.findCartItemByMemberId(memberDtoByLoginId.getMemberId());
        model.addAttribute("carts", CartItemConverter.getCartItemResultDto(cartItems));
        model.addAttribute("stockQuantity", cartItemService.getStockQuantity(cartItems));
        return "carts/cartList";

    }

}
