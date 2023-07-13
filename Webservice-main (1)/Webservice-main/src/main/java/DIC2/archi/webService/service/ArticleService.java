package DIC2.archi.webService.service;

import DIC2.archi.webService.domain.Article;

import java.util.List;

public interface ArticleService {
    Article create(Article a);
    Article update(Long id, Article a);
    String delete(Long id);
    List<Article> getAllArticles();

    List<Article> getArticlesByPage(Long pageNumber);
}
