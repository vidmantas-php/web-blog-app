package lt.web.demo.entities;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    @NotEmpty
    private String itemName;

    @Column(name = "item_category")
    @NotEmpty
    private String itemCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "item_value")
    @DecimalMin("0.01")
    @NotNull
    private BigDecimal itemValue;

    @Column(name = "price_for_day")
    @DecimalMin("0.01")
    @NotNull
    private BigDecimal itemPriceForDay;

    @Column(name = "item_picture_id")
    @NotEmpty
    private String itemPictureId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categories_id")
//    private Categories itemCategories;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Categories itemCategories;

}