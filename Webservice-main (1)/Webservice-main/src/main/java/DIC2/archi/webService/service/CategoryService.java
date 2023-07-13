package DIC2.archi.webService.service;

import DIC2.archi.webService.domain.Article;
import DIC2.archi.webService.domain.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category c);
    List<Category> getAllCategories();
    Category update(Long id, Category c);
    String delete(Long id);
    List<Article> getArticlesByCategory(Long categoryId);

}
