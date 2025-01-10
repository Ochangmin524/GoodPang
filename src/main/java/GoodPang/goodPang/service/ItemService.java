package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.ItemConverter;
import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.CartItemRepository;
import GoodPang.goodPang.repository.CartRepository;
import GoodPang.goodPang.repository.ItemRepository;
import GoodPang.goodPang.repository.MemberRepository;
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
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
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



        //아이템 삭제
        itemRepository.deleteById(itemId);

        return itemId;
    }


    @Transactional
    public Item addItem(ItemRequestDto.AddItemDto request) {
        //상품 생성
        Item item = ItemConverter.toItem(request);

        //상품 저장
        return itemRepository.save(item);
    }
}
