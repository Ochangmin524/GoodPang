package GoodPang.goodPang.api.dto;

import GoodPang.goodPang.domain.enums.DeliveryStatus;
import GoodPang.goodPang.domain.member.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DeliveryResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeliveryDto {
        Long deliveryId;
        Address address;
        DeliveryStatus status;

    }
}
