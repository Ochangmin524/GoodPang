package GoodPang.goodPang.domain.item;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter //@Getter 자동생성
@Builder // 빌더 패턴으로 자동으로 만들어주는 에노테이션
@NoArgsConstructor(access =  AccessLevel.PROTECTED) //기본 생성자 자종 생성
@AllArgsConstructor
public class LikedItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
