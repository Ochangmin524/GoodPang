package GoodPang.goodPang.repository.customRepository;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomItemRepository {
    Page<Item> findItemsPageByCriteria(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Pageable pageable);
    List<Item> findItemsListByCriteria(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Pageable pageable);
}
