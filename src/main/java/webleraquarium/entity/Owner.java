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
public class Owner {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private String emailAddress;
}
