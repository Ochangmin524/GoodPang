package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.LikedItemConverter;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.ItemRepository;
import GoodPang.goodPang.repository.LikedItemRepository;
import GoodPang.goodPang.repository.MemberRepository;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.exception.handler.LikedItemHandler;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.LikedItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //좋아요 취소
    @Transactional
    public Long cancelLikedItem(LikedItemRequestDto.CancelLikedItem request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
        LikedItem likedItem = likedItemRepository.findById(request.getLikedItemId()).orElseThrow(() -> new LikedItemHandler(ErrorStatus._LIKED_ITEM_NOT_FOUND));
        Item item = itemRepository.findById(likedItem.getItem().getId()).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));
        likedItemRepository.delete(likedItem); // DB에서 삭제
        item.minusLikes(1); //좋아요 수 감소

        member.getLikedItems().remove(likedItem); // 자동으로 지워지려나..?
        return likedItem.getId();

    }

    @Transactional(readOnly = true)
    public List<LikedItem> getLikedItemListByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
        return likedItemRepository.findAllByMember(member);
    }
}
