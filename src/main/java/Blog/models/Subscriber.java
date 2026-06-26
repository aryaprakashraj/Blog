package Blog.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="subscribers")

public class Subscriber {

    @Id
    private String mail ;

    private String name ;

    private LocalDateTime subscribedAt ;

    @PrePersist
    public void prePersist(){
        if (status == null) {
            status = "Subscribed";
        }
        subscribedAt = LocalDateTime.now() ;
    }

    private String status ;
}
