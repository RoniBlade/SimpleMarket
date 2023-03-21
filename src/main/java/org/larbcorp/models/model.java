

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
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//import lombok.Data;
//    import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "products")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String description;
//    private String organization;
//    private double price;
//    private int quantity;
//    private String discountInfo;
//    private String reviews;
//    private String keywords;
//    private String characteristics;
//
//    // constructors, getters and setters
//}
//
//
//
//
//import lombok.Data;
//    import javax.persistence.*;
//    import java.util.List;
//
//@Data
//@Entity
//@Table(name = "discounts")
//public class Discount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private double amount;
//    private String duration;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "discount_product",
//        joinColumns = @JoinColumn(name = "discount_id"),
//        inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;
//
//    // constructors, getters and setters
//}
//
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//    import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, Long> {
//}
//
//@Repository
//public interface DiscountRepository extends JpaRepository<Discount, Long> {
//}
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.stereotype.Service;
//    import java.util.List;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public Product getProductById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
//
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
//}
//
//@Service
//public class DiscountService {
//    @Autowired
//    private DiscountRepository discountRepository;
//
//    public List<Discount> getAllDiscounts() {
//        return discountRepository.findAll();
//    }
//
//    public Discount getDiscountById(Long id) {
//        return discountRepository.findById(id).orElse(null);
//    }
//
//    public Discount saveDiscount(Discount discount) {
//        return discountRepository.save(discount);
//    }
//
//    public void deleteDiscount(Long id) {
//        discountRepository.deleteById(id);
//    }
//}
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.http.HttpStatus;
//    import org.springframework.http.ResponseEntity;
//    import org.springframework.web.bind.annotation.*;
//    import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
//        Product product = productService.getProductById(id);
//        if (product != null) {
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/products")
//    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        Product savedProduct = productService.saveProduct(product);
//        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/products/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
