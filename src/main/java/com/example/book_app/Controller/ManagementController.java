package com.example.book_app.Controller;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.AuthorRepo;
import com.example.book_app.Repository.BookRepo;
import com.example.book_app.Service.AuthorService;
import com.example.book_app.Service.BookService;
import com.example.book_app.Service.PendingApprovalService;
import com.example.book_app.Util.ApprovalUtil;
import com.example.book_app.functionalities.IntegerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/management")
public class ManagementController {

    @Autowired
    private PendingApprovalService pendingApprovalService;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/pendingBookApprovals")
    public List<PendingApproval> pendingBookApprovals(){
        return pendingApprovalService.getAllPendingApprovals();
    }

    //add conditions to check if the book is already in the database
    @DeleteMapping("/approveBook")
    public void approveBook(@RequestBody IntegerList integerList){
        List<Integer> bookIds = integerList.getIntegers();
        for(int i:bookIds){
            PendingApproval p = pendingApprovalService.getPendingApprovalById(i);
            Book book = new ApprovalUtil().convertPendingBookToBook(p);
            bookRepo.save(book);
            int id =book.getAuthorId();
            Author oldAuthor =authorRepo.findById(id).get();
            oldAuthor.getBookList().add(book);
            authorService.updateAuthor(oldAuthor);
            pendingApprovalService.deletePendingApproval(i);
        }
    }
    @DeleteMapping("/rejectBook")
    public void rejectBook(@RequestBody IntegerList integerList){
        List<Integer> bookIds = integerList.getIntegers();
        for(int i:bookIds){
            pendingApprovalService.deletePendingApproval(i);
        }
    }


}
