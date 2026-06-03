package com.example.trainee_app;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private static List<Author> autherList= new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();

    @GetMapping("/add-author")
    public String addAuthor(@RequestParam int id,
                            @RequestParam String name,
                            @RequestParam String biography){
        Author author = new Author(id,name,biography);
        autherList.add(author);
        return "Author added successfully!";
    }

    @GetMapping("/all-authors")
    public List<Author> allAuthors(){
        return autherList;
    }
}
