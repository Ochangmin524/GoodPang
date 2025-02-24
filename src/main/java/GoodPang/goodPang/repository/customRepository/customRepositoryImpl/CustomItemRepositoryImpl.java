package GoodPang.goodPang.repository.customRepository.customRepositoryImpl;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.QItem;
import GoodPang.goodPang.repository.customRepository.CustomItemRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository {
    private final JPAQueryFactory jpaQueryFactory; //쿼리 자동생성
    private final QItem item = QItem.item;





    @Override
    public PageImpl<Item> findItemsPageByCriteria(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Pageable pageable) {
        JPQLQuery<Item> query = getItemJPQLQuery(category, minPrice, maxPrice, minLikes, sortBy, pageable);
        long total = query.fetchCount();
        List<Item> items = query.fetch();
        return new PageImpl<>(items, pageable, total);
    }
    @Override
    public List<Item> findItemsListByCriteria(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Pageable pageable) {
        JPQLQuery<Item> query = getItemJPQLQuery(category, minPrice, maxPrice, minLikes, sortBy, pageable);
        return query.fetch();

        }

    //쿼리 생성 메소드
    private JPQLQuery<Item> getItemJPQLQuery(Category category, Integer minPrice, Integer maxPrice, Integer minLikes, String sortBy, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        //필터링 조건 추가

        //카테고리
        if (category != null) {predicate.and(item.category.eq(category));}

        //가격
        if (minPrice != null && maxPrice != null) {predicate.and(item.price.between(minPrice, maxPrice));}
        else if (minPrice != null) {predicate.and(item.price.goe(minPrice));}
        else if (maxPrice != null) {predicate.and(item.price.loe(maxPrice));}

        //좋아요
        if (minLikes != null) {predicate.and(item.likes.goe(minLikes));}


        //쿼리 작성 + 위의 필터링 조건 적용
        JPQLQuery<Item> query =  jpaQueryFactory.selectFrom(item).where(predicate);

        //정렬 조건 추가
        if (sortBy != null) {
            if (sortBy.equals("높은가격순")) {query.orderBy(item.price.desc());}
            else if (sortBy.equals("낮은가격순")) {query.orderBy(item.price.asc());}
            else if (sortBy.equals("좋아요순")) {query.orderBy(item.likes.desc());}
            else if (sortBy.equals("최신순")) {query.orderBy(item.createdAt.desc());}
        }


        //쿼리에 페이징 설정 추가
        query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        return query;
    }

}
