package GoodPang.goodPang.domain.member;

import GoodPang.goodPang.domain.base.BaseEntity;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자종 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 새성자 생성
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;


    @OneToOne
    @JoinColumn(name = "member_image_id")
    private MemberImage memberImage;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private String loginId;
    private String password;

    //cascade로, member가 지워지면 자동으로 삭제, orphan으로 like리스트에서 사라지면 자동으로 db에서 like 삭제
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikedItem> likedItems = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Orders> orders = new ArrayList<>();

    public void setCart(Cart cart) {
        this.cart = cart;
        cart.setMember(this);
    }

    public Member editMember(String name, Address address) {
        this.name = name;
        this.address = address;
        return this;
    }
    public void addLikedItem(LikedItem likedItem) {
        this.likedItems.add(likedItem);
    }
}
