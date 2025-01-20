package GoodPang.goodPang.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -2002406172L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final GoodPang.goodPang.domain.base.QBaseEntity _super = new GoodPang.goodPang.domain.base.QBaseEntity(this);

    public final QAddress address;

    public final GoodPang.goodPang.domain.cart.QCart cart;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<GoodPang.goodPang.domain.item.LikedItem, GoodPang.goodPang.domain.item.QLikedItem> likedItems = this.<GoodPang.goodPang.domain.item.LikedItem, GoodPang.goodPang.domain.item.QLikedItem>createList("likedItems", GoodPang.goodPang.domain.item.LikedItem.class, GoodPang.goodPang.domain.item.QLikedItem.class, PathInits.DIRECT2);

    public final StringPath loginId = createString("loginId");

    public final GoodPang.goodPang.domain.images.QMemberImage memberImage;

    public final StringPath name = createString("name");

    public final ListPath<GoodPang.goodPang.domain.order.Orders, GoodPang.goodPang.domain.order.QOrders> orders = this.<GoodPang.goodPang.domain.order.Orders, GoodPang.goodPang.domain.order.QOrders>createList("orders", GoodPang.goodPang.domain.order.Orders.class, GoodPang.goodPang.domain.order.QOrders.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final EnumPath<GoodPang.goodPang.domain.enums.MemberRole> role = createEnum("role", GoodPang.goodPang.domain.enums.MemberRole.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.cart = inits.isInitialized("cart") ? new GoodPang.goodPang.domain.cart.QCart(forProperty("cart"), inits.get("cart")) : null;
        this.memberImage = inits.isInitialized("memberImage") ? new GoodPang.goodPang.domain.images.QMemberImage(forProperty("memberImage"), inits.get("memberImage")) : null;
    }

}

