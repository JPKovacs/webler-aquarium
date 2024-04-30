package webleraquarium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aquarium {

    @Column(nullable = false, unique = true)
    private Double size;

    @Column(nullable = false)
    private Long capacity;

    @Column(nullable = false)
    private Double temperature;

    @Column(nullable = false)
    private String waterType;

}
