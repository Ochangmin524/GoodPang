package GoodPang.goodPang.repository.customRepository;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;

import java.util.List;

public interface CustomItemRepository {
    List<Item> findItemsByCriteria(Category category,Integer minPrice,Integer maxPrice, Integer minLikes, String sortBy, Integer page);
}
