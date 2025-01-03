package GoodPang.goodPang.domain.item;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.images.ItemImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price; //가격

    private int stockQuantity; //재고수량

    private int likes = 0; // 좋아요 수

    @Enumerated(EnumType.STRING)
    private Category category;

    private String information; // 상품 설명

    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
    private List<ItemImage> imageFiles;//등록과 저장된 이미지 파일

}
