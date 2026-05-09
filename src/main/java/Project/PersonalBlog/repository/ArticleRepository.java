package Project.PersonalBlog.repository;

import Project.PersonalBlog.models.Article ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByStatus(String status) ;
    List<Article> findByStatusOrderByCreatedAtDesc(String status) ;
}
