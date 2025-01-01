package GoodPang.goodPang.domain.member;

import GoodPang.goodPang.base.BaseEntity;
import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.images.MemberImage;
import GoodPang.goodPang.domain.item.LikedItem;
import GoodPang.goodPang.domain.order.Orders;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter //@Getter 자동생성
@Builder // 빌더 패턴으로 자동으로 만들어주는 에노테이션
@NoArgsConstructor(access =  AccessLevel.PROTECTED) //기본 생성자 자종 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 새성자 생성
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE)
    private List<Orders> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_image_id")
    private MemberImage memberImage;



    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private String loginId;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<LikedItem> likedItems = new ArrayList<>();



}
