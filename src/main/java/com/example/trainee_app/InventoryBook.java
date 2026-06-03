package com.example.trainee_app;

public class InventoryBook {
    private int bookId;
    private String title;
    private double price;
    private int stockCount;

    public InventoryBook(int bookId, String title, int stockCount, double price) {
        this.bookId = bookId;
        this.title = title;
        this.stockCount = stockCount;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getStockCount() {
        return stockCount;
    }
}
