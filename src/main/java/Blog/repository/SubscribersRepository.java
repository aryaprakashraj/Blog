package Blog.repository;

import Blog.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscribersRepository extends JpaRepository<Subscriber, String> {
    List<Subscriber> findByStatus(String status) ;
}
