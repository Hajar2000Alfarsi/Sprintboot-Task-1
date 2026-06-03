package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    private static List<InventoryBook> inventory = new ArrayList<>();

    @GetMapping("addInventoryBook")
    public String addInventoryBook(@RequestParam int bookId,
                                   @RequestParam String title,
                                   @RequestParam double price,
                                   @RequestParam int stockCount){

    }
}
