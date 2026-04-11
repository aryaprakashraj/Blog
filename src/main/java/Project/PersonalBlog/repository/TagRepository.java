package Project.PersonalBlog.repository;

import Project.PersonalBlog.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag , Long> {
    Tag findByName(String name) ;
}
