package com.aryaprakashraj.Blog.repository;

import com.aryaprakashraj.Blog.models.Article ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByStatus(String status) ;
    List<Article> findByStatusOrderByCreatedAtDesc(String status) ;
}
