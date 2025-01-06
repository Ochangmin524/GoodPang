package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.DeliveryStatus;
import GoodPang.goodPang.domain.order.Delivery;
import GoodPang.goodPang.web.dto.OrderRequestDto;

public class DeliveryConverter {
    public static Delivery toDelivery(OrderRequestDto.createOrderDto request) {
        return Delivery.builder()
                .address(request.getAddress())
                .status(DeliveryStatus.READY)
                .build();
    }
}
