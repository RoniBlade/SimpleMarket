//package org.larbcorp.services;
//
//
//import org.larbcorp.models.Product;
//import org.springframework.stereotype.Service;
//import org.larbcorp.repositories.ProductRepository;
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    private ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
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