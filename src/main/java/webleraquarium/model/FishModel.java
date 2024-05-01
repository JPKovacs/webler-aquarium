package webleraquarium.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FishModel {

    private String species;
    private String color;
    private Long age;
    private Double weight;
}
