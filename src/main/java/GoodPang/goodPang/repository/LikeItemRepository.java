package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.item.LikedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeItemRepository extends JpaRepository<LikedItem, Long> {
}
