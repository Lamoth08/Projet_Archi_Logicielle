package DIC2.archi.webService.controlleur;

import DIC2.archi.webService.domain.Article;
import DIC2.archi.webService.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/articles")
public class ArticleControlleur {
    private final ArticleService articleService;
    @GetMapping("/read")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/get/{pageNumber}")
    public List<Article> getArticleByPage(@RequestParam(defaultValue = "0") Long pageNumber) { return articleService.getArticlesByPage(pageNumber);}

    @PostMapping("/create")
    public Article  createArticle(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("update/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.update(id, article);
    }

    @DeleteMapping("delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        return articleService.delete(id);
    }
}