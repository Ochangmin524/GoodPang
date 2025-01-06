package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.LikedItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.ItemRepository;
import GoodPang.goodPang.repository.LikedItemRepository;
import GoodPang.goodPang.repository.MemberRepository;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.LikedItemRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikedItemService {
    private final LikedItemRepository likedItemRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public LikedItem addLikedItem(LikedItemRequestDto.AddLikedItem request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
        Item item = itemRepository.findById(request.getItemId()).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));

        LikedItem likedItem = LikedItemConverter.toLikedItem(member, item);
        item.addLikes(1);
        member.addLikedItem(likedItem);
        return likedItemRepository.save(likedItem);

    }
}
