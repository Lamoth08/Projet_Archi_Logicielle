package DIC2.archi.webService.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Article")
@Getter
@Setter
@NoArgsConstructor
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_seq",
            sequenceName = "article_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "article_seq"
    )

    private Integer id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(columnDefinition="TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

}
