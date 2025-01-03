package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.ItemService;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import GoodPang.goodPang.web.dto.ItemResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;

    @PostMapping("/items/additem")
    public ApiResponse<ItemResponseDto.AddResultDto> addItem(@RequestBody @Valid ItemRequestDto.AddItemDto request) {
        Item item = itemService.addItem(request);
        return ApiResponse.onSuccess(ItemConverter.toAddResultDTO(item));
    }

}
