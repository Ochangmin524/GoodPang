package GoodPang.goodPang.domain.member;

import GoodPang.goodPang.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

//주소 관련된 것들은 이쪽에서 관리하기!
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable//Address라는 타입을 사용하기 위해
public class Address  {
    private String city;
    private String street;
    private String zipcode;

}
