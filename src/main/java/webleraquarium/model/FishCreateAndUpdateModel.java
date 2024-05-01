package webleraquarium.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FishCreateAndUpdateModel {

    private String species;
    private String color;
    private Long age;
    private Double weight;
}
