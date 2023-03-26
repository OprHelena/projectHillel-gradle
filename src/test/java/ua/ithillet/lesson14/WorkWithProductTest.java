package ua.ithillet.lesson14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkWithProductTest {

    WorkWithProduct work = new WorkWithProduct();

    private List<Product> targetList;

    @BeforeEach
    public void fillProductListIn() {
        targetList = new ArrayList<>();
        targetList.add(new Product("Books", 250.23, true, LocalDate.now().minusDays(5)));
        targetList.add(new Product("Books", 10.15, false, LocalDate.now().plusMonths(1)));
        targetList.add(new Product("Books", 100.0, true, LocalDate.now().minusWeeks(1)));
        targetList.add(new Product("Books", 50.55, false, LocalDate.now().plusDays(10)));
        targetList.add(new Product("Fruits", 1250.23, false, LocalDate.now().plusMonths(10)));
        targetList.add(new Product("Books", 452.01, true, LocalDate.now().minusYears(1)));
        targetList.add(new Product("Books", 500.23, false, LocalDate.now().plusYears(2)));
        targetList.add(new Product("Books", 250.00, true, LocalDate.now().plusWeeks(4)));
        targetList.add(new Product("Books", 249.99, false, LocalDate.now().plusDays(45)));
        targetList.add(new Product("Books", 3254.23, true, LocalDate.now().plusDays(5)));
        targetList.add(new Product("Fruits", 23.23, true, LocalDate.now().plusMonths(2)));
        targetList.add(new Product("Books", 45.20, true, LocalDate.now().plusDays(22)));
        targetList.add(new Product("Fruits", 503.05, true, LocalDate.now().plusMonths(1)));
    }

    @Test
    public void testGetProductListMethod() {
        assertEquals(4, work.getProductByCategoryAndPrice(targetList, "Books", 250.0).size());
    }

    @Test
    public void testGetListOfProductByCategoryAndDiscount() {
        assertEquals(targetList.get(0).getPrice() * 0.9,
                work.getListOfProductByCategoryAndDiscount(targetList, "Books").get(0).getPrice());
        assertEquals(6, work.getListOfProductByCategoryAndDiscount(targetList, "Books").size());
    }

    @Test
    public void testGetCheapestProductByCategory() {
        assertEquals(10.15, work.getCheapestProductByCategory(targetList, "Books").getPrice());
    }

    @Test
    public void testGetLastThreeAddedProducts() {
        assertEquals(3, work.getLastThreeAddedProducts(targetList).size());
        assertEquals(targetList.get(6), work.getLastThreeAddedProducts(targetList).get(0));
        assertEquals(targetList.get(4), work.getLastThreeAddedProducts(targetList).get(1));
        assertEquals(targetList.get(10), work.getLastThreeAddedProducts(targetList).get(2));
    }

    @Test
    public void testCalculatedCostOfProducts() {
        assertEquals(105.90, work.calculatedCostOfProducts(targetList, "Books", 75.00));
    }

    @Test
    public void testGroupProductsByCategory() {
        assertEquals(2, work.groupProductsByCategory(targetList).size());
        assertEquals(3, work.groupProductsByCategory(targetList).get("Fruits").size());
        assertEquals(10, work.groupProductsByCategory(targetList).get("Books").size());
    }
}
