package ua.ithillet.lesson14;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class WorkWithProduct {

    public List<Product> getProductByCategoryAndPrice(List<Product> productList, String category, double price) {
        return productList.stream()
                .filter(product -> product.getCategory().equals(category) && product.getPrice() > price).toList();
    }

    public List<Product> getListOfProductByCategoryAndDiscount(List<Product> productList, String category) {
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .filter(product -> product.getDiscount() == true)
                .peek(product -> product.setPrice(product.getPrice() * 0.9)).toList();
    }

    public Product getCheapestProductByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("No product found with category " + category));
    }

    public List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
    }

    public double calculatedCostOfProducts(List<Product> products, String category, double price) {
        return products.stream()
                .filter(p -> p.getCategory().equals(category))
                .filter(p -> p.getPrice() <= price)
                .filter(p -> p.getDate().getYear() == LocalDate.now().getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

}
