package Project.PersonalBlog.controller;

import Project.PersonalBlog.models.Tag;
import Project.PersonalBlog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService ;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.createTag(tag)) ;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags()) ;
    }

}
