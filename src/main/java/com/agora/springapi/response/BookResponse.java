package com.agora.springapi.response;

import com.agora.springapi.entity.Books;
import com.agora.springapi.result.Result;

import java.util.List;

public class BookResponse {
    List<Books> responseBooks;
    public List<Books> getResponseBooks() {
        return responseBooks;
    }

    public void setResponseBooks(List<Books> responseBooks) {
        this.responseBooks = responseBooks;
    }
    public BookResponse(Result bookResult){
        this.bookResult = bookResult;
    }

    private Result bookResult;

    public Result getBookResult() {
        return bookResult;
    }

    public void setBookResult(Result bookResult) {
        this.bookResult = bookResult;
    }
}
