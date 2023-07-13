package DIC2.archi.webService.service;

import DIC2.archi.webService.domain.Article;
import DIC2.archi.webService.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article create(Article a) {
        return articleRepository.save(a);
    }

    @Override
    public Article update(Long id, Article a) {
        return articleRepository.findById(id)
                .map(article->{
                    article.setTitle(a.getTitle());
                    article.setDescription(a.getDescription());
                    article.setContent(a.getContent());
                    return articleRepository.save(article);
                }).orElseThrow(() -> new RuntimeException("article non trouve"));

    }
    @Override
    public String delete(Long id) {
        articleRepository.deleteById(id);
        return "Article deleted";
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticlesByPage(Long pageNumer) {
        Pageable page = PageRequest.of(Math.toIntExact(pageNumer), 4, Sort.by("id").descending());
        return  articleRepository.findAll( page).getContent();
    }


}
