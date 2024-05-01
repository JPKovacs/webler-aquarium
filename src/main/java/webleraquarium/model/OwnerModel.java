package webleraquarium.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerModel {

    private String name;
    private Long age;
    private String emailAddress;
}


