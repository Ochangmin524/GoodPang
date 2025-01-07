package GoodPang.goodPang.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class LikedItemResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //생성된 장바구니 상품의 id 반환
    public static class AddLikedItemResultDto {
        Long likedItemID;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //삭제된 장바구니 상품의 id 반환
    public static class CancelLikedItemResultDto {
        Long likedItemID;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //좋아요 상품 조회 결과
    public static class GetLikedItemResultDto {
        Integer numOfLikedItems;
        List<LikedItemDTO> likedItems;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LikedItemDTO {
        Long likedItemID;
        String name;
    }


}
