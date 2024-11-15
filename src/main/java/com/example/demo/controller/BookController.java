package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;




    @GetMapping("")
    public Page<Book> getBookByAuthorAndTitle(@RequestParam(required = false, defaultValue = "") String author,
                                              @RequestParam(required = false, defaultValue = "") String title,
                                              Pageable pageable){
        return bookService.findByTitleAndAuthorContainingIgnoreCase(title,author,pageable);
    }
}
