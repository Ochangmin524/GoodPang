package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.OrderConverter;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.OrderService;
import GoodPang.goodPang.web.dto.OrderRequestDto;
import GoodPang.goodPang.web.dto.OrderResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    //장바구니에 담긴 제품 일괄 구매, 리스트 안에 장바구니 아이템을 담아 주세요
    @PostMapping("/orders")
    public ApiResponse<OrderResponseDto.createOrderResultDto> createOrder(@RequestBody @Valid OrderRequestDto.createOrderDto request) {
        Orders order = orderService.createOrder(request);
        return ApiResponse.onSuccess(OrderConverter.toCreateOrderResponseDto(order));
    }
}