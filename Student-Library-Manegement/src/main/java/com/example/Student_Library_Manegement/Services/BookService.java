package com.example.Student_Library_Manegement.Services;

import com.example.Student_Library_Manegement.Converter.BookConverter;
import com.example.Student_Library_Manegement.Model.Author;
import com.example.Student_Library_Manegement.Model.Book;
import com.example.Student_Library_Manegement.Repository.AuthorRepository;
import com.example.Student_Library_Manegement.Repository.BookRepository;
import com.example.Student_Library_Manegement.RequestDto.BookRequestdto;
import com.example.Student_Library_Manegement.enums.Genre;
import com.example.Student_Library_Manegement.enums.PurcBookStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    Logger logger = LoggerFactory.getLogger(BookService.class);
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public String saveBook(BookRequestdto bookRequestdto){
        Book book = BookConverter.ConvertBookdtoToBookModel(bookRequestdto);
        Author author = authorRepository.findById(bookRequestdto.getAuthorId()).get();
        book.setAuthor(author);
        book.setBookStore(PurcBookStore.NOTALLOCATED);
        book.setAllocatedbookquantity(0);
        bookRepository.save(book);
       return "Book saved Success.....";
    }
    public List<Book> getAllBook(){
        List<Book> books = bookRepository.findAll();
        return books;
    }
    public List<Book> getBookOnPagination(int pageNo,int pageSize,String title){
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(title).descending()));
        List<Book> bookList = new ArrayList<>();
        for(Book book:bookPage){
            bookList.add(book);
        }
        return bookList;
    }
    public Book getBookByTitle(String title){
        Book book = bookRepository.findByTitle(title);
        return book;
    }
    public List<Book> getBookByPages(int pages){
        logger.info("getByBookPages Method Started");
        List<Book> books = bookRepository.findByPages(pages);
        if(books.size()==0){
            logger.error("getByBookPages Throw error");
            throw new RuntimeException("Book Not Found");
        }
        logger.info("getByBookPages Method ended");
        return books;
    }
    public Book getBookByTitleAndPages(String title, int pages){
        Book book = bookRepository.findByTitleAndPages(title,pages);
        return book;
    }
    public List<Book> getBookByGenre(Genre genre){
        List<Book> books = bookRepository.findByGenre(genre);
        return books;
    }

}
