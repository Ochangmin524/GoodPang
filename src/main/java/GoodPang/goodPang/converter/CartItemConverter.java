package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.api.dto.CartItemRequestDto;
import GoodPang.goodPang.api.dto.CartItemResponseDto;

import java.util.List;
import java.util.stream.Collectors;


public class CartItemConverter {

    public static CartItemResponseDto.DeleteCartItemResultDto toDeleteCartItemResult(Long cartItemId) {
        return CartItemResponseDto.DeleteCartItemResultDto.builder()
                .cartItemId(cartItemId)
                .build();
    }

    public static CartItemResponseDto.GetCartItemResultDto getCartItemResultDto(List<CartItem> cartItemList) {
        return CartItemResponseDto.GetCartItemResultDto
                .builder()
                .numOfCartItems(cartItemList.size())
                .cartItems(toCartItemList(cartItemList))
                .build();
    }

    private static List<CartItemResponseDto.CartItemDto> toCartItemList(List<CartItem> cartItemList) {
        return cartItemList.stream().map(CartItemConverter::toCartItemDto).collect(Collectors.toList());
    }

    public static CartItemResponseDto.CartItemDto toCartItemDto(CartItem cartItem) {
        return CartItemResponseDto.CartItemDto.builder()
                .cartItemId(cartItem.getId())
                .itemId(cartItem.getItem().getId())
                .price(cartItem.getItem().getPrice())
                .quantity(cartItem.getCount())
                .itemName(cartItem.getItem().getName())
                .build();
    }

    public static CartItemResponseDto.AddResultDto toAddCartItemResult(CartItem cartItem) {
        return CartItemResponseDto.AddResultDto.builder()
                .cartItemID(cartItem.getId())
                .build();
    }

    public static CartItem toCartItem(CartItemRequestDto.AddCartItem request, Item item) {
        return CartItem.builder()
                .item(item)
                .count(request.getCount())
                .build();
    }
}
