package GoodPang.goodPang.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("A")
@Getter
@Builder(builderMethodName = "AlbumBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class Album extends Item{
    private String artist;
    private String atc;
}
