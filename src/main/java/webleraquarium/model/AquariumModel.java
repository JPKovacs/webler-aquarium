package webleraquarium.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AquariumModel {

    private Double size;
    private Long capacity;
    private Double temperature;
    private String waterType;

}

