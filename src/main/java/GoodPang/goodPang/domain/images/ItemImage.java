package GoodPang.goodPang.domain.images;

import GoodPang.goodPang.base.BaseEntity;
import GoodPang.goodPang.domain.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ItemImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uploadFile_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    private String uploadFileName; //등록한 파일 이름

    private String storeFileName; //서버에 저장되는 파일 이름

}
