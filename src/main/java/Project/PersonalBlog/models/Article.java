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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_tags",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    private List<Tag> tags = new ArrayList<>();


}
