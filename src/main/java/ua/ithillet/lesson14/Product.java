package ua.ithillet.lesson14;


import java.time.LocalDate;

public class Product {

    private String category;
    private double price;
    private boolean discount;
    private LocalDate date;

    public Product(String category, double price, boolean discount, LocalDate date) {
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

   public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", getDiscount='" + discount + '\'' +
                ", addingTime='" + date + '\'' +
                '}';
    }
}
