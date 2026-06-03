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

    @GetMapping("/addAuthor")
    public String addAuthor(@RequestParam int id,
                            @RequestParam String name,
                            @RequestParam String biography){
        Author author = new Author(id,name,biography);
        autherList.add(author);
        return "Author added successfully!";
    }

    @GetMapping("/allAuthors")
    public List<Author> allAuthors(){
        return autherList;
    }

    @GetMapping("/addRelationalBook")
    public String addRelationalBook(@RequestParam int id,
                                    @RequestParam String name,
                                    @RequestParam int authorId){
        boolean authorExists = false;
        for (Author author : autherList){
            if (author.getId() == authorId){
                authorExists = true;
                break;
            }
        }

        if (authorExists == true){
            Book book =  new Book(id,name,authorId);
            bookList.add(book);
            return "Book added successfully under valid author!";
        } else {
            return "Error: Author ID not found. Book was not added.";
        }
    }

    @GetMapping("/authorReport")
    public String authorReport(@RequestParam String authorName) {
        Author foundAuthor = null;

        for (Author author1 : autherList){
            if (author1.getName().equalsIgnoreCase(authorName)){
                foundAuthor = author1;
                break;
            }
        }

        if (foundAuthor ==  null) {
            return "Error: Author not found.";
        }

        Book foundBook = null;

        for (Book book : bookList) {
            if (book.getAuthorId() == foundAuthor.getId()){
                foundBook = book;
                break;
            }
        }

        StringBuilder report = new StringBuilder();

        report.append("Author Report <br>");
        report.append("------------------------------------<br>");
        report.append("Name: ").append(foundAuthor.getName()).append("<br>");
        report.append("Biography: ").append(foundAuthor.getBiography()).append("<br>");
        report.append("<br>Book Written: <br>");
        if (foundBook != null) {
            report.append(foundBook.getName()).append("<br>");
        } else {
            report.append("None");
        }

        return report.toString();
    }

}
