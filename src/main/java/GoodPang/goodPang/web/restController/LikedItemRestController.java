package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.LikedItemConverter;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.LikedItemService;
import GoodPang.goodPang.web.dto.LikedItemRequestDto;
import GoodPang.goodPang.web.dto.LikedItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikedItemRestController {
    private final LikedItemService likedItemService;

    @PostMapping("/likedItems")
    public ApiResponse<LikedItemResponseDto.AddLikedItemResultDto> addLikedItem(LikedItemRequestDto.AddLikedItem request) {
        LikedItem likedItem = likedItemService.addLikedItem(request);
        return ApiResponse.onSuccess(LikedItemConverter.toAddLikedItemResultDto(likedItem));
    }
}
