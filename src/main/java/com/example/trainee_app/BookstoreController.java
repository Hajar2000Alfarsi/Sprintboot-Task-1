package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    private static List<InventoryBook> inventorylist = new ArrayList<>();

    @GetMapping("addInventoryBook")
    public String addInventoryBook(@RequestParam int bookId,
                                   @RequestParam String title,
                                   @RequestParam double price,
                                   @RequestParam int stockCount){
        InventoryBook inventoryBook = new InventoryBook(bookId,title,stockCount,price);
        inventorylist.add(inventoryBook);
        return "Book added successfully to bookstore inventory!";
    }

    @GetMapping("checkStock")
    public String checkStock(@RequestParam int bookId) {
        for (InventoryBook inventoryBook : inventorylist) {
            if (inventoryBook.getBookId() == bookId) {
                if (inventoryBook.getStockCount() > 0) {
                    return "Book Available  <br>"+
                            "Title: " + inventoryBook.getTitle() + "<br>"+
                            "Price: $" + inventoryBook.getPrice();
                } else {
                    return "Sold Out<br>" +
                            "Title: " + inventoryBook.getTitle();
                }
            }
        }
        return "Sorry, this bookstore does not carry that book.";
    }

    @GetMapping("lowStochReport")
    public String lowStochReport(@RequestParam int threshold){
        String report = "";
        boolean found = false;

        for (InventoryBook inventoryBook : inventorylist){
            if (inventoryBook.getStockCount() <= threshold){
                report += "Title: " + inventoryBook.getTitle() + "<br>" +
                        "Stock: " + inventoryBook.getStockCount() + "<br>";
                found = true;
            }
        }

        if (!found){
            return "No books currently need reordering.";
        }
        return report;
    }
}
