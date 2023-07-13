package DIC2.archi.webService.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "Category")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(
            name = "cat_seq",
            sequenceName = "cat_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cat_seq"
    )
    private Integer id;

    private String libelle;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Article> articles;

}