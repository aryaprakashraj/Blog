package Project.PersonalBlog.controller;

import Project.PersonalBlog.config.JwtUtil;
import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil ;

    private final ArticleService articleService ;

    @Value("${admin.username}")
    private String admin ;

    @Value("${admin.password}")
    private String pass ;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String , String> body){
        String username = body.get("username") ;
        String password = body.get("password") ;

        if (admin.equals(username) && pass.equals(password)){
            String token = jwtUtil.generateToken(username) ;
            return ResponseEntity.ok(Map.of("token" , token)) ;
        }

        return ResponseEntity.status(401).body(Map.of("error" , "Invalid credentials")) ;
    }

}
