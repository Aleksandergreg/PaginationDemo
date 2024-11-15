package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;



    public Page<Book> findByTitleAndAuthorContainingIgnoreCase(String title, String author, Pageable pageable){
        return bookRepository.findByTitleAndAuthorContainingIgnoreCase(title, author,pageable);
    }
}

