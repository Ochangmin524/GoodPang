package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.web.dto.LikedItemResponseDto;

public class LikedItemConverter {

    public static LikedItemResponseDto.AddLikedItemResultDto toAddLikedItemResultDto(LikedItem likedItem) {
        return LikedItemResponseDto.AddLikedItemResultDto.builder()
                .likedItemID(likedItem.getId())
                .build();
    }

    public static LikedItemResponseDto.CancelLikedItemResultDto toCancelLikedItemResultDto(Long likedItemId) {
        return LikedItemResponseDto.CancelLikedItemResultDto.builder()
                .likedItemID(likedItemId).build();
    }
    public static LikedItem toLikedItem(Member member, Item item) {
        return LikedItem.builder()
                .member(member)
                .item(item)
                .build();
    }
}
