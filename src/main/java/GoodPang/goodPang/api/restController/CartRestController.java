package GoodPang.goodPang.api.restController;

import GoodPang.goodPang.converter.CartItemConverter;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.CartItemService;
import GoodPang.goodPang.api.dto.CartItemRequestDto;
import GoodPang.goodPang.api.dto.CartItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartRestController {
    private final CartItemService cartItemService;

    //장바구니 담기 요청
    @PostMapping("/carts/addCartItem")
    public ApiResponse<CartItemResponseDto.AddResultDto> addCartItem(@RequestBody CartItemRequestDto.AddCartItem request) {
        CartItem cartItem = cartItemService.addCartItem(request);
        return ApiResponse.onSuccess(CartItemConverter.toAddCartItemResult(cartItem));
    }

    //장바구니 조회
    @GetMapping("/carts/{memberId}")
    public ApiResponse<CartItemResponseDto.GetCartItemResultDto> getCartItemList(@PathVariable("memberId") Long memberId) {
        return ApiResponse.onSuccess(CartItemConverter.getCartItemResultDto(cartItemService.findCartItemByMemberId(memberId)));
    }

    //장바구니 상품 삭제
    @DeleteMapping("/carts")
    public ApiResponse<CartItemResponseDto.DeleteCartItemResultDto> deleteCartItem(@RequestBody CartItemRequestDto.DeleteCartItem request) {
        return ApiResponse.onSuccess(CartItemConverter.toDeleteCartItemResult(cartItemService.deleteCartItem(request)));
    }
    //장바구니 상품 수량 수정
    @PatchMapping("/updateCartItemQuantity")
    public ApiResponse<CartItemResponseDto.CartItemDto> updateCartItemQuantity(@RequestBody CartItemRequestDto.updateCartItemQuantity request) {
        return ApiResponse.onSuccess(CartItemConverter.toCartItemDto(cartItemService.updateCartItemQuantity(request.getCartItemId(), request.getQuantity())));
    }
}
