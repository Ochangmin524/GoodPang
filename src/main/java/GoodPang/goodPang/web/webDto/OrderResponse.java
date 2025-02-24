package GoodPang.goodPang.web.webDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OrderResponse {

    @Builder
    @Getter
    @Setter
    public static class OrderListDto {
        List<OrderList> orderList;

    }
    @Builder
    @Getter
    @Setter
    public static class OrderList {
        List<OrderDetail> orderDetailList;

    }


    @Builder
    @Getter
    @Setter
    public static class OrderDetail {
        Long itemId;
        String name; //구매한 상품명
        Integer totalPrice; // 총가격
        Integer count; // 구매 수량
        String status; //구매 상태
        String orderDate; //구매날짜
    }
}
