package com.example.Student_Library_Manegement.Controller;

import com.example.Student_Library_Manegement.Model.Book;
import com.example.Student_Library_Manegement.RequestDto.BookRequestdto;
import com.example.Student_Library_Manegement.Services.BookService;
import com.example.Student_Library_Manegement.enums.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookService bookService;
  @PostMapping("/save")
    public String saveBook(@RequestBody  BookRequestdto bookRequestdto){
      String response = bookService.saveBook(bookRequestdto);
      return response;
  }
  @GetMapping("/getall")
  public List<Book> getAllBook(){
      List<Book> books = bookService.getAllBook();
      return books;
  }
  @GetMapping("/pages")
  public List<Book> getBookOnPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam String title){
      List<Book> bookList = bookService.getBookOnPagination(pageNo,pageSize,title);
      return bookList;
  }
  @GetMapping("/getByTitle")
    public Book getByBookTitle(@RequestParam("title") String title){
      Book book = bookService.getBookByTitle(title);
      return book;
  }
    @GetMapping("/getByPages")
    public ResponseEntity<?> getByBookPages(@RequestParam("pages") int pages){
        try {
            logger.info("getByBookPages API Started");
            List<Book> books = bookService.getBookByPages(pages);
            logger.info("getByBookPages API ended");
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            logger.error("getByBookPages API got error"+e.getMessage());
            return ResponseEntity.internalServerError().body("Some error occured"+e.getMessage());
        }
    }
    @GetMapping("/findByTitleAndPages")
    public Book getBookByTitle(@RequestParam("title") String title, @RequestParam("pages") int pages){
        Book book= bookService.getBookByTitleAndPages(title,pages);
        return book;
    }
  @GetMapping("/getbygenre")
    public List<Book> getBookByGenre(@RequestParam("genre") Genre genre){
      List<Book> books = bookService.getBookByGenre(genre);
      return books;
  }
}