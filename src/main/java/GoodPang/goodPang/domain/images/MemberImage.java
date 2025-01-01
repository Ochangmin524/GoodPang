package GoodPang.goodPang.domain.images;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.member.Member;
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
public class MemberImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "memberImage", fetch = FetchType.LAZY)
    private Member member;


    private String uploadFileName; //등록한 파일 이름

    private String storeFileName; //서버에 저장되는 파일 이름

}
