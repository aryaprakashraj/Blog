package Project.PersonalBlog.service;

import Project.PersonalBlog.models.Tag;
import Project.PersonalBlog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository ;

    public Tag createTag(Tag tag){
        return getOrCreateTag(tag.getName()) ;
    }

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag getOrCreateTag(String name) {
        String normalized = name.trim().toLowerCase() ;
        Tag existing = tagRepository.findByName(normalized);
        if (existing != null) return existing ;
        Tag newTag = new Tag() ;
        newTag.setName(normalized);
        return tagRepository.save(newTag) ;
    }
}
