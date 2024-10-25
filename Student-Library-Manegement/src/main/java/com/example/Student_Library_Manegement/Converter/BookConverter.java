package com.example.Student_Library_Manegement.Converter;

import com.example.Student_Library_Manegement.Model.Book;
import com.example.Student_Library_Manegement.RequestDto.BookRequestdto;

public class BookConverter {
    public static Book ConvertBookdtoToBookModel(BookRequestdto bookRequestdto){
        Book book = Book.builder().pages(bookRequestdto.getPages()).title(bookRequestdto.getTitle()).genre(bookRequestdto.getGenre()).quantity(bookRequestdto.getQuantity()).build();
        return book;
    }
}
