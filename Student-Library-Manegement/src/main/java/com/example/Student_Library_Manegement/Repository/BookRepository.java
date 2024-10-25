package com.example.Student_Library_Manegement.Repository;

import com.example.Student_Library_Manegement.Model.Book;
import com.example.Student_Library_Manegement.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findByTitle(String title);
    public List<Book> findByPages(int pages);
    public Book findByTitleAndPages(String title,int pages);

    @Query(nativeQuery = true,value = "select * from book where genre=:inputGenre")
    public List<Book> findByGenre(Genre inputGenre);
}
