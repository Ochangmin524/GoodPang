package GoodPang.goodPang.domain.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //부모 클래스를 테이블과 매핑하지 않는다 -> 자식이 명시할 필요 x-> 엔티티가 x -> 테이블 생성 x
                  //해당 클래스를 상속하는 엔티티는 칼럼 정보만 제공한다.
@EntityListeners(AuditingEntityListener.class) //변경감지
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private LocalDateTime updatedAt;
}
