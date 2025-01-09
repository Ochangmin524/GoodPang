package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.member.Address;
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
    public static class cancelOrderDto{
        Long orderId;
    }

}
