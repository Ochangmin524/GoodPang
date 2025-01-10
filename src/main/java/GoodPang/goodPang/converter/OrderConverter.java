package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.OrderStatus;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.OrderItem;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.web.dto.OrderResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {
    public static OrderResponseDto.getOrderDto toGetOrderDto(Orders orders) {
        return OrderResponseDto.getOrderDto.builder()
                .orderId(orders.getId())
                .count(orders.getOrderItems().size())
                .orderStatus(orders.getStatus())
                .delivery(DeliveryConverter.toDeliveryDto(orders.getDelivery()))
                .orderItems(toOrderItemList(orders.getOrderItems()))
                .build();
    }

    private static List<OrderResponseDto.orderItemDto> toOrderItemList(List<OrderItem> orderItems) {
        return orderItems.stream().map(OrderConverter::toOrderItemDto).collect(Collectors.toList());
    }

    private static OrderResponseDto.orderItemDto toOrderItemDto(OrderItem orderItem) {
        return OrderResponseDto.orderItemDto.builder()
                .itemId(orderItem.getItem().getId())
                .orderItemId(orderItem.getId())
                .orderPrice(orderItem.getOrderPrice())
                .count(orderItem.getCount())
                .build();
    }

    public static OrderResponseDto.toOrderResultDto toChangeOrderResultDto(Orders orders){
        return OrderResponseDto.toOrderResultDto.builder()
                .orderId(orders.getId())
                .status(orders.getStatus())
                .build();
    }


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
