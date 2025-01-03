package GoodPang.goodPang.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("M")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends Item{
    private String director;
    private String actor;
}
