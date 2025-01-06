package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ItemResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //생성된 상품의 id 반환
    public static class AddResultDto {
        Long itemID;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //생성된 상품의 id 반환
    public static class GetItemDto {
        Long itemID;
        String name;
        int price;
        int stockQuantity;
        int likes;
        Category category;
        String information;
    }


}
