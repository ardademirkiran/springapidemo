package com.agora.springapi.controller;

import com.agora.springapi.entity.Books;
import com.agora.springapi.request.BookRequest;
import com.agora.springapi.response.BookResponse;
import com.agora.springapi.result.Result;
import com.agora.springapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/bookmanagement")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<?> getBooks(@RequestBody BookRequest bookRequest) {
        HashMap<String, Integer> categoriesAndAmounts = new HashMap<>();
        categoriesAndAmounts.put("Mystery", bookRequest.getMystery());
        categoriesAndAmounts.put("Sci-Fi", bookRequest.getSci_fi());
        categoriesAndAmounts.put("Romance", bookRequest.getRomance());
        categoriesAndAmounts.put("Novel", bookRequest.getNovel());
        ArrayList<Page<Books>> paginatedBooks = bookService.getBooks(bookRequest.getPage(), categoriesAndAmounts);
        BookResponse bookResponse = new BookResponse(new Result("B1","Books fetched successfully"));
        bookResponse.setResponseBooks(flattenBooks(paginatedBooks));
        return ResponseEntity.ok().body(bookResponse);
    }

    List<Books> flattenBooks( ArrayList<Page<Books>> paginatedBooks){
        List<Books> allBooks = new ArrayList<>();
        for(Page<Books> page: paginatedBooks){
            allBooks.addAll(page.getContent());
        }
        return allBooks;
    }
}
