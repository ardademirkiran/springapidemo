package com.agora.springapi.service;

import com.agora.springapi.entity.Books;
import com.agora.springapi.repository.BookRepository;
import com.agora.springapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ArrayList<Page<Books>> getBooks(int pageNumber, HashMap<Integer,String> amounts){
        ArrayList<Page<Books>> products = new ArrayList<>();

        for(Integer amount: amounts.keySet()){
            Pageable pageable = PageRequest.of(pageNumber,amount);
            products.add(bookRepository.findByCategory(pageable,amounts.get(amount)));
        }

        return products;
    }
}
