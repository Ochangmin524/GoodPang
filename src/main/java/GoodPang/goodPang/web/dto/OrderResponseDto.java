package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderResponseDto {
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
    public static class cancelOrderResultDto {
        Long orderId;
        OrderStatus status;

    }
}
