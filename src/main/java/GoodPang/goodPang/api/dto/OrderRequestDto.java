package GoodPang.goodPang.api.dto;

import GoodPang.goodPang.domain.enums.OrderStatus;
import GoodPang.goodPang.domain.member.Address;
import GoodPang.goodPang.domain.order.Delivery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OrderRequestDto {

    @Getter
    @Setter
    public static class createOrderDto{
        Long memberId;// 결제할 회원의 아이디
        List<Long> cartItemId;//결제할 장바구니 상품 아이디
        Address address; //배송 정보
    }



    @Getter
    @Setter
    public static class changeOrderDto{
        Long orderId;
        OrderStatus orderStatus;
    }



}
