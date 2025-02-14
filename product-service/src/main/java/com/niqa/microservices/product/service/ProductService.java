package com.niqa.microservices.product.service;

import com.niqa.microservices.product.dto.ProductRequest;
import com.niqa.microservices.product.dto.ProductResponse;
import com.niqa.microservices.product.model.Product;
import com.niqa.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {  // Nama kelas tanpa spasi
    private final ProductRepository productRepository;
    
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())  // Jika pakai record, gunakan ini
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}

//     public ProductResponse createProduct(ProductRequest productRequest) {
//         Product product = Product.builder()
//                 .name(productRequest.name())  // Jika pakai record, gunakan ini
//                 .description(productRequest.description())
//                 .price(productRequest.price())
//                 .build();        
//         productRepository.save(product);
//         log.info("Product created successfully");  // Logging yang benar
//         return new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice());
//     }

//     public List<Product> getAllProducts() {
//         return productRepository.findAll();
//             .stream()
//             .map(product -> new ProductResponse(product.getId(), product.getname(), product.getDescription(),product.getPrice()))
//             .toList();
//     }
// }