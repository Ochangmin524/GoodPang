package GoodPang.goodPang.api.restController;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.ItemService;
import GoodPang.goodPang.api.dto.ItemRequestDto;
import GoodPang.goodPang.api.dto.ItemResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
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

    @DeleteMapping("/items/delete")
    public ApiResponse<ItemResponseDto.DeleteResultDto> deleteItem(@RequestBody @Valid ItemRequestDto.DeleteItemDto request) {
        return ApiResponse.onSuccess(ItemConverter.toDeleteResultDto(itemService.deleteItem(request.getItemId())));
    }

    @GetMapping("/items/search")
    public ApiResponse<ItemResponseDto.GetAllItemResultDto> searchItem(@RequestParam(value = "category", required = false) Category category,
                                                                       @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                                                       @RequestParam(value = "maxPrice", required = false) Integer maxPrice,
                                                                       @RequestParam(value = "minLikes", required = false) Integer minLikes,
                                                                       @RequestParam(value = "sortBy", required = false) String sortBy,
                                                                       @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                                       @RequestParam(value = "size", required = false, defaultValue = "9") Integer size) {


        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));

        List<Item> items = itemService.searchItemsList(category, minPrice, maxPrice, minLikes, sortBy, pageable);
        return ApiResponse.onSuccess(ItemConverter.toGetAllItemResultDTO(items));
    }
}
