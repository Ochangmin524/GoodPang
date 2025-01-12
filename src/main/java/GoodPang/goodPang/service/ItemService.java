package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.OrderItem;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.repository.*;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));
    }


    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    @Transactional
    public Long deleteItem(Long itemId) {

        Item item = itemRepository.findById(itemId).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));

        List<Member> allMembers = memberRepository.findAll();


        allMembers.forEach(member -> {
            //CartItem 제거 -> orphanRemoval 리스트에서 삭제되면 자동으로 db에 반영
            member.getCart().getCarts().removeIf(cartItem -> cartItem.getItem().getId().equals(itemId));
            //LikedItem 제거 -> orphanRemoval 리스트에서 삭제되면 자동으로 db에 반영
            member.getLikedItems().removeIf(likedItem -> likedItem.getItem().getId().equals(itemId));
        });

        //orderItem 처리, 상품 삭제 이후, 조회 시 정보 집어넣기
        List<OrderItem> allOrderItems = orderItemRepository.findAll();
        allOrderItems.stream().filter(orderItem -> orderItem.getItem() != null && orderItem.getItem().getId().equals(itemId))
                .forEach(orderItem -> orderItem.deleteOrders(item));


        //아이템 삭제
        itemRepository.deleteById(itemId);

        return itemId;
    }

    @Transactional(readOnly = true)
    public List<Item> searchItems(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Integer page) {
        List<Item> itemsByCriteria = itemRepository.findItemsByCriteria(category, minPrice, maxPrice, minLikes, sortBy, page);
        return itemsByCriteria;

    }

    @Transactional
    public Item addItem(ItemRequestDto.AddItemDto request) {
        //상품 생성
        Item item = ItemConverter.toItem(request);
        //상품 저장
        return itemRepository.save(item);
    }
}
