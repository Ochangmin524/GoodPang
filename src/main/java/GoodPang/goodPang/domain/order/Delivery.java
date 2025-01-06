package GoodPang.goodPang.domain.order;

import GoodPang.goodPang.domain.base.BaseEntity;
import GoodPang.goodPang.domain.enums.DeliveryStatus;
import GoodPang.goodPang.domain.member.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Orders orders;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
