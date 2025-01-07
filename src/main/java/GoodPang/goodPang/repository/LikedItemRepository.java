package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedItemRepository extends JpaRepository<LikedItem, Long> {
    List<LikedItem> findAllByMember(Member member);
}
