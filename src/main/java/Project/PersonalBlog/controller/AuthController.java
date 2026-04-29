package Project.PersonalBlog.controller;

import Project.PersonalBlog.config.JwtUtil;
import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil ;

    private final ArticleService articleService ;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String , String> body){
        String username = body.get("username") ;
        String password = body.get("password") ;

        if ("arya".equals(username) && "yourpassword".equals(password)){
            String token = jwtUtil.generateToken(username) ;
            return ResponseEntity.ok(Map.of("token" , token)) ;
        }

        return ResponseEntity.status(401).body(Map.of("error" , "Invalid credentials")) ;
    }

    @DeleteMapping("/{id}/tags")
    public ResponseEntity<Article> removeTag(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(articleService.removeTagFromArticle(id, body.get("name")));
    }
}
