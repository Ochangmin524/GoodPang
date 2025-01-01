package GoodPang.goodPang.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("M")
@Getter
@Builder(builderMethodName = "MovieBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends Item{
    private String director;
    private String actor;
}
