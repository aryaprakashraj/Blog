package Blog.repository;

import Blog.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
    List<Newsletter> findByStatusOrderByCreatedAtDesc(String status) ;
}