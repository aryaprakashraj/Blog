package Project.PersonalBlog.service;
import Project.PersonalBlog.models.Article;
import Project.PersonalBlog.models.Tag;
import Project.PersonalBlog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.* ;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository ;
    private final TagService tagService;

    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll() ;
    }

    public Article getArticleById(Long id){
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found!"));
        article.setViewCount(article.getViewCount() + 1);
        articleRepository.save(article);
        return article ;
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

    public List<Article> getPublishedArticles(){
        return articleRepository.findByStatus("PUBLISHED") ;
    }

    public Article addTagToArticle(Long articleId , String tagName){
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new RuntimeException("Article not found"));
        Tag tag = tagService.getOrCreateTag(tagName) ;
        if (!article.getTags().contains(tag)) article.getTags().add(tag) ;
        return articleRepository.save(article) ;
    }

    public Article removeTagFromArticle(Long articleId, String tagName){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        Tag tag = tagService.getOrCreateTag(tagName);
        article.getTags().remove(tag);
        return articleRepository.save(article);
    }
}