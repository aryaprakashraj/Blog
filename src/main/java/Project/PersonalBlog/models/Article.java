package Project.PersonalBlog.models;

import jakarta.persistence.*;
import lombok.Data ;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "articles")

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String title ;

    private LocalDateTime updatedAt ;

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

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now() ;
    }

}
