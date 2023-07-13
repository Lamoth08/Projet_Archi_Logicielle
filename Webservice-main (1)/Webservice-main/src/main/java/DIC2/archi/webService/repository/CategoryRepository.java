package DIC2.archi.webService.repository;

import DIC2.archi.webService.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}