package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.ItemService;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import GoodPang.goodPang.web.dto.ItemResponseDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;

    @PostMapping("/items/additem")
    public ApiResponse<ItemResponseDto.AddResultDto> addItem(@RequestBody @Valid ItemRequestDto.AddItemDto request) {
        Item item = itemService.addItem(request);
        return ApiResponse.onSuccess(ItemConverter.toAddResultDTO(item));
    }

    @GetMapping("/items/{itemId}")
    public ApiResponse<ItemResponseDto.GetItemDto> getItem(@PathVariable("itemId") Long itemId) {
        return ApiResponse.onSuccess(ItemConverter.toGetItemDTO(itemService.getItem(itemId)));
    }

    @GetMapping("/items/all")
    public ApiResponse<ItemResponseDto.GetAllItemResultDto> getAllItems() {
        return ApiResponse.onSuccess(ItemConverter.toGetAllItemResultDTO(itemService.getAllItems()));
    }
}
