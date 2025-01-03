package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.repository.ItemRepository;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Item addItem(ItemRequestDto.AddItemDto request) {
        //상품 생성
        Item item = ItemConverter.toItem(request);

        //상품 저장
        return itemRepository.save(item);
    }
}
