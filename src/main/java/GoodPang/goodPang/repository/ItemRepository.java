package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.repository.customRepository.CustomItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> , CustomItemRepository {
}
