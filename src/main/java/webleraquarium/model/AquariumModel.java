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
public class AquariumModel {

    private Double size;
    private Long capacity;
    private Double temperature;
    private String waterType;
}

