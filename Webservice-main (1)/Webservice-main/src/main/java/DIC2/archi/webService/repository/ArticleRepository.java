package DIC2.archi.webService.repository;

import DIC2.archi.webService.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}