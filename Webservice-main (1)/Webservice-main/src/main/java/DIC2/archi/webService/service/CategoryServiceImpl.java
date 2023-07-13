package DIC2.archi.webService.service;

import DIC2.archi.webService.domain.Article;
import DIC2.archi.webService.domain.Category;
import DIC2.archi.webService.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Long id, Category c) {
         return categoryRepository.findById(id)
                 .map(cat->{
                     cat.setLibelle(c.getLibelle());
                     return categoryRepository.save(c);
                 }).orElseThrow(() -> new RuntimeException("category not found"));

    }
    @Override
    public String delete(Long id) {
        categoryRepository.deleteById(id);
        return "Category deleted";
    }

    @Override
    public List<Article> getArticlesByCategory(Long categoryId) {
        Category cat = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("category not found"));
        return new ArrayList<>(cat.getArticles());

    }

}
