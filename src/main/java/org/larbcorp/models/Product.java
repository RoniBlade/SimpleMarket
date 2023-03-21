package org.larbcorp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "organization_id")
//    private Organization organization;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private Set<Discount> discounts;

//    @OneToMany(mappedBy = "product")
//    private Set<Review> reviews;

    @ElementCollection
    private Set<String> keywords;

//    @OneToMany(mappedBy = "product")
//    private Set<ProductAttribute> attributes;
//
//    @OneToMany(mappedBy = "product")
//    private Set<Rating> ratings;
}
