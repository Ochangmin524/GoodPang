package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.api.dto.LikedItemResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class LikedItemConverter {

    public static LikedItemResponseDto.GetLikedItemResultDto getLikedItemResultDto(List<LikedItem> items) {
        return LikedItemResponseDto.GetLikedItemResultDto.builder()
                .numOfLikedItems(items.size())
                .likedItems(toLikedItemListDTO(items))
                .build();

    }

    private static List<LikedItemResponseDto.LikedItemDTO> toLikedItemListDTO(List<LikedItem> items) {
        return items.stream().map(LikedItemConverter::toLikedItemDTO).collect(Collectors.toList());
    }

    private static LikedItemResponseDto.LikedItemDTO toLikedItemDTO(LikedItem item) {
        return LikedItemResponseDto.LikedItemDTO.builder()
                .likedItemID(item.getId())
                .name(item.getItem().getName())
                .build();
    }

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
