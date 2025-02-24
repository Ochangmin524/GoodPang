package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.OrderStatus;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.OrderItem;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.api.dto.OrderResponseDto;
import GoodPang.goodPang.web.webDto.OrderResponse;

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
        if (orderItem.getItem() == null) {
            return  OrderResponseDto.orderItemDto.builder()
                    .itemId(0L) //삭제된 상품은 0의 id를 가진다고 하자
                    .orderItemId(orderItem.getId())
                    .orderPrice(orderItem.getOrderPrice())
                    .count(orderItem.getCount())
                    .build();
        }

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

    public static OrderResponse.OrderListDto toOrderResultDto(List<Orders> orders) {
        List<OrderResponse.OrderList> orderList = orders.stream().map(order -> toOrderList(order)).collect(Collectors.toList());
        return OrderResponse.OrderListDto.builder()
                .orderList(orderList).build();
    }

    private static OrderResponse.OrderList toOrderList(Orders order) {
        List<OrderItem> orderItems = order.getOrderItems();
        List<OrderResponse.OrderDetail> orderDetailList = orderItems.stream()
                .map(orderItem -> toOrderDetail(orderItem, order)).collect(Collectors.toList());
        return OrderResponse.OrderList.builder()
                .orderDetailList(orderDetailList).build();
    }

    private static OrderResponse.OrderDetail toOrderDetail(OrderItem orderItem, Orders order) {
        Item item = orderItem.getItem();
        return OrderResponse.OrderDetail.builder()
                .itemId(item.getId())
                .name(item.getName())
                .totalPrice(orderItem.getOrderPrice())
                .count(orderItem.getCount())
                .status(order.getStatus().name())
                .orderDate(String.valueOf(order.getOrderDate())).build();
    }

}
