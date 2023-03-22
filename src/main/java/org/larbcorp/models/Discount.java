//package org.larbcorp.models;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@NoArgsConstructor
//public class Discount {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Column(nullable = false)
//    private BigDecimal discountAmount;
//
//    @Column(nullable = false)
//    private LocalDateTime startDate;
//
//    @Column(nullable = false)
//    private LocalDateTime endDate;
//}