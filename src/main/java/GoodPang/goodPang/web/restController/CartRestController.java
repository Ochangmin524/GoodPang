package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.CartConverter;
import GoodPang.goodPang.converter.CartItemConverter;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.CartItemService;
import GoodPang.goodPang.web.dto.CartItemRequestDto;
import GoodPang.goodPang.web.dto.CartItemResponseDto;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartRestController {
    private final CartItemService cartItemService;

    //장바구니 담기 요청
    @PostMapping("carts/addCartItem")
    public ApiResponse<CartItemResponseDto.AddResultDto> addCartItem(@RequestBody CartItemRequestDto.AddCartItem request    ) {
        CartItem cartItem = cartItemService.addCartItem(request);
        return ApiResponse.onSuccess(CartItemConverter.toAddCartItemResult(cartItem));
    }

}
