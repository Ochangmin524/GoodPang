package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.repository.ItemRepository;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));
    }


    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item addItem(ItemRequestDto.AddItemDto request) {
        //상품 생성
        Item item = ItemConverter.toItem(request);

        //상품 저장
        return itemRepository.save(item);
    }
}
