package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.enums.OrderStatus;
import lombok.*;

import java.util.List;

public class OrderResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class toOrderResultDto {
        Long orderId;
        OrderStatus status;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createOrderResultDto {
        Long orderId; //생성된 주문의 아이디
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class toChangeOrderResultDto {
        Long orderId;
        OrderStatus status;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getOrderDto{
        Long orderId;
        Integer count;
        OrderStatus orderStatus;
        DeliveryResponseDto.DeliveryDto delivery;
        List<orderItemDto> orderItems;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class orderItemDto {
        Long orderItemId;
        Long itemId;
        Integer count;
        Integer orderPrice;


    }
}
