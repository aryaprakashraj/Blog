package Project.PersonalBlog.controller;

import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService ;

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @GetMapping()
    public ResponseEntity<List<Article>> getPublishedArticles(){
        return ResponseEntity.ok(articleService.getPublishedArticles()) ;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id){
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build() ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody Article article){
        return ResponseEntity.ok(articleService.updateArticle(id, article));
    }

    @PostMapping("/{id}/tags")
    public ResponseEntity<Article> addTag(@PathVariable("id") Long id , @RequestBody Map<String , String> body){
        return ResponseEntity.ok(articleService.addTagToArticle(id , body.get("name"))) ;
    }

    @DeleteMapping("/{id}/tags")
    public ResponseEntity<Article> removeTag(@PathVariable("id") Long id , @RequestBody Map<String, String> body){
        return ResponseEntity.ok(articleService.removeTagFromArticle(id, body.get("name"))) ;
    }
}
