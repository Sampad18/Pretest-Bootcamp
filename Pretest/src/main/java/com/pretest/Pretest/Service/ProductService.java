package com.pretest.Pretest.Service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    public ProductList sortProducts(ProductList productList) {
        List<Product> list = productList.getProductList().stream().
                sorted(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed())
//                .sorted(Comparator.comparing(Product::getLaunchDate).reversed())
                .collect(Collectors.toList());
        return new ProductList(list);

    }

   /* public ProductList createProducts(ProductList productList) {
        List<Product> products = productList.getProductList().stream().map(product -> productRepo.save(product))
                .collect(Collectors.toList());
        return new ProductList(products);


    }

    public List<Product> getAllProducts() {
        List<Product> products= new ArrayList<>();
        for (Product product : productRepo.findAll()) {
            products.add(product);
        }
        return products;
    }

    public Product getById(String id) {
        return productRepo.findById(id).get();
    }
}*/
}

