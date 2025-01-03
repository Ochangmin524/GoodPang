package GoodPang.goodPang.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("B")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Item{
    private String author;
    private String isbn;
}
