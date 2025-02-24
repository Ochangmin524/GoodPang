package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.DeliveryStatus;
import GoodPang.goodPang.domain.order.Delivery;
import GoodPang.goodPang.api.dto.DeliveryResponseDto;
import GoodPang.goodPang.api.dto.OrderRequestDto;

public class DeliveryConverter {
    public static Delivery toDelivery(OrderRequestDto.createOrderDto request) {
        return Delivery.builder()
                .address(request.getAddress())
                .status(DeliveryStatus.READY)
                .build();
    }


    public static DeliveryResponseDto.DeliveryDto toDeliveryDto(Delivery delivery) {
        return DeliveryResponseDto.DeliveryDto
                .builder()
                .deliveryId(delivery.getId())
                .status(delivery.getStatus())
                .address(delivery.getAddress())
                .build();

    }
}
