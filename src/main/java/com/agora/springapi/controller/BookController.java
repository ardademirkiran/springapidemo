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

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/books")
    public ResponseEntity<?> getBooks(@RequestBody BookRequest bookRequest) {
        HashMap<Integer,String> categories = new HashMap<>();

        categories.put(bookRequest.getMystery(), "Mystery");
        categories.put(bookRequest.getSci_fi(), "Sci-Fi");
        categories.put(bookRequest.getRomance(), "Romance");
        categories.put(bookRequest.getNovel(), "Novel");

        List<Books> allBooks = new ArrayList<>();

        for(Page<Books> page: bookService.getBooks(bookRequest.getPage(), categories)){
            allBooks.addAll(page.getContent());
        }
        BookResponse bookResponse = new BookResponse(new Result("B1","Books fetched successfully"));
        bookResponse.setResponseBooks(allBooks);
        return ResponseEntity.ok().body(bookResponse);
    }
}
