package Project.PersonalBlog.service;
import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.* ;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository ;

    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll() ;
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found!"));
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    public Article updateArticle(Long id, Article updated){
        Article existing = getArticleById(id);
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        existing.setStatus(updated.getStatus());
        return articleRepository.save(existing);
    }
}