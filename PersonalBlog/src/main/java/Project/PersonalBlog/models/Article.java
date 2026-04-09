package Project.PersonalBlog.models;

import jakarta.persistence.*;
import lombok.Data ;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "articles")

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String title ;

    @Column(columnDefinition = "TEXT")
    private String content ;

    private String status ;

    private LocalDateTime createdAt ;

    private int viewCount ;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now() ;
        viewCount = 0 ;
        if (status == null) status = "DRAFT" ;
    }


}
