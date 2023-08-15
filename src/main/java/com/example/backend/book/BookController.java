package com.example.backend.book;

import com.example.backend.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "book")
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping()
    public String test(){
        return "Book route is working";
    }

    @GetMapping("/all")
    public List<Book> getBooks(){
        return books;
    }

    @GetMapping("/info/{id}")
    public Book getBookInfo(@PathVariable Long id){
        for (Book book : books) {
            if(Objects.equals(book.id, id)){
                return book;
            }
        }
        return new Book();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book bookData){
        Book newBook = new Book(bookData.name,bookData.author,bookData.quantity,bookData.releasedYear);
        books.add(newBook);
        return newBook;
    }

    @PutMapping("/update/{id}")
    public Optional<Book> udpateBook(@PathVariable Long id, @RequestBody Optional<Book> bookData){
        for (int i = 0; i < books.size(); i++) {
            if(Objects.equals(books.get(i).id, id)){
                if(bookData.isPresent()){
                    Book updatedData = bookData.get();
                    updatedData.id = books.get(i).id;
                    books.set(i,updatedData);
                }
            }
        }
        return bookData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, @RequestBody Optional<Book> bookData){
        for (int i = 0; i < books.size(); i++) {
            if(Objects.equals(books.get(i).id, id)){
                books.remove(i);
                return "Deleted successfully";
            }
        }
        return "Sorry id is not present";
    }
}
