package com.example.book_app.Util;

import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Model.Book;
public class ApprovalUtil {
     public Book convertPendingBookToBook(PendingApproval p) {

        Book book = new Book();
        book.setBookId(p.getBookId());
        book.setBookName(p.getBookName());
        book.setAuthorId(p.getAuthorId());
        book.setAuthorName(p.getAuthorName());
        book.setPrice(p.getPrice());
        return book;
    }
}
