package Project.PersonalBlog.controller;

import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService ;

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("?{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id){
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build() ;
    }

}
