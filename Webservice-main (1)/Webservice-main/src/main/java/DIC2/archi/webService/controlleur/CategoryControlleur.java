package DIC2.archi.webService.controlleur;

import DIC2.archi.webService.domain.Article;
import DIC2.archi.webService.domain.Category;
import DIC2.archi.webService.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryControlleur {

   private final CategoryService categoryService;

    @GetMapping("/read")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}/articles")
    public List<Article> getArticlesByCategory(@PathVariable Long categoryId) {
        return categoryService.getArticlesByCategory(categoryId);
    }
    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PutMapping("update/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        return categoryService.delete(id);
    }
}
