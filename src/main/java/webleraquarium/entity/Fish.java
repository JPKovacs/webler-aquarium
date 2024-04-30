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
public class Fish {

    @Column(nullable = false, unique = true)
    private String species;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private Double weight;

}
