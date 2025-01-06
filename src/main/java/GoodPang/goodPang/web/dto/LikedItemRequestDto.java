package GoodPang.goodPang.web.dto;

import lombok.Getter;
import lombok.Setter;

public class LikedItemRequestDto {
    @Getter
    @Setter
    public static class AddLikedItem{
        Long memberId;
        Long itemId;
    }
    @Getter
    @Setter
    public static class CancelLikedItem{
        Long memberId;
        Long likedItemId;
    }
}
