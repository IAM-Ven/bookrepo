package com.ventoday.bookrepo.controller;

import com.ventoday.bookrepo.dto.BookDto;
import com.ventoday.bookrepo.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class BookController {

    private BookService bookService;

    @GetMapping(value = "/books")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/book/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable("id") long id) {
        BookDto bookDto = bookService.getBookById(id);
        return ResponseEntity.ok().body(bookDto);
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<BookDto> updateBookById(@PathVariable("id") long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBookById(id, bookDto));
    }

    /*@PostMapping(value = "/saveBook")
    public ResponseEntity<BookDto> createBook(BookDto bookDto){
        return ResponseEntity.ok(bookService.)
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}