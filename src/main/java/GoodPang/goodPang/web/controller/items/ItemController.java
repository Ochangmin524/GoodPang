package GoodPang.goodPang.web.controller.items;

import GoodPang.goodPang.api.dto.CartItemRequestDto;
import GoodPang.goodPang.api.dto.ItemResponseDto;
import GoodPang.goodPang.api.dto.MemberResponseDto;
import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.service.ItemService;
import GoodPang.goodPang.service.MemberService;
import GoodPang.goodPang.web.webConverter.WebItemConverter;
import GoodPang.goodPang.web.webDto.webItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final MemberService memberService;

    @GetMapping("/items/search")
    public String searchItem(@RequestParam(value = "category", required = false) Category category,
                             @RequestParam(value = "minPrice", required = false) Integer minPrice,
                             @RequestParam(value = "maxPrice", required = false) Integer maxPrice,
                             @RequestParam(value = "minLikes", required = false) Integer minLikes,
                             @RequestParam(value = "sortBy", required = false) String sortBy,
                             @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "9") Integer size,
                             Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Item> items = itemService.searchItemsPage(category, minPrice, maxPrice, minLikes, sortBy, pageable);
        int totalPages = items.getTotalPages();
        model.addAttribute("items", WebItemConverter.toItemListDto(items));
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("page", page);
        model.addAttribute("member", memberService.getMemberDtoByLoginId());
        return "items/itemList";
    }


    @GetMapping("items/{itemId}")
    public String itemDetail(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.getItem(itemId);
        model.addAttribute("item", WebItemConverter.toItemDetailDto(item));
        model.addAttribute("addCartForm", new CartItemRequestDto.AddCartItem());
        model.addAttribute("member", memberService.getMemberDtoByLoginId());
        model.addAttribute("isLiked", memberService.getIsLiked(itemId));
        return "items/itemDetail";
    }

}
