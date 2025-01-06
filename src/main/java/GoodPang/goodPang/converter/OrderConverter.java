package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.OrderStatus;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.web.dto.OrderResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderConverter {

    public static OrderResponseDto.createOrderResultDto toCreateOrderResponseDto(Orders orders) {
        return OrderResponseDto.createOrderResultDto.builder()
                .orderId(orders.getId())
                .build();
    }

    public static Orders toOrder(Member member) {
        return Orders.builder()
                .member(member)
                .orderItems(new ArrayList<>())
                .status(OrderStatus.ORDER)
                .orderDate(LocalDateTime.now())
                .build();

    }
}
