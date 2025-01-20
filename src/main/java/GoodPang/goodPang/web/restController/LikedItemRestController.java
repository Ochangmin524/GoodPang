package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.LikedItemConverter;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.LikedItemService;
import GoodPang.goodPang.web.dto.LikedItemRequestDto;
import GoodPang.goodPang.web.dto.LikedItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikedItemRestController {
    private final LikedItemService likedItemService;

    @PostMapping("/likedItems")
    public ApiResponse<LikedItemResponseDto.AddLikedItemResultDto> addLikedItem(LikedItemRequestDto.AddLikedItem request) {
        LikedItem likedItem = likedItemService.addLikedItem(request);
        return ApiResponse.onSuccess(LikedItemConverter.toAddLikedItemResultDto(likedItem));
    }

    @DeleteMapping("/likedItems")
    public ApiResponse<LikedItemResponseDto.CancelLikedItemResultDto> cancelLikedItem(LikedItemRequestDto.CancelLikedItem request) {
        Long cancelLikedItemId = likedItemService.cancelLikedItem(request);
        return ApiResponse.onSuccess(LikedItemConverter.toCancelLikedItemResultDto(cancelLikedItemId));

    }

    @GetMapping("/likedItems/{memberId}")
    public ApiResponse<LikedItemResponseDto.GetLikedItemResultDto> getLikedItem(@PathVariable("memberId") Long memberId) {
        return ApiResponse.onSuccess(LikedItemConverter.getLikedItemResultDto(likedItemService.getLikedItemListByMemberId(memberId)));
    }
}
