package lt.web.demo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long categoriesId;

    @Column(name = "category")
    @NotEmpty
    private String category;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "itemCategories")
    private Set<Item> items = new HashSet<>(0);

}