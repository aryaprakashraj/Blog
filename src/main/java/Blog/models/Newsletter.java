package Blog.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "newsletters")
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private LocalDateTime createdAt ;

    private String subject ;

    @Column(columnDefinition = "TEXT")
    private String body ;

    private String status ;

}
