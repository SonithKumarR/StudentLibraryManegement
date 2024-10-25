package com.example.Student_Library_Manegement.RequestDto;

import com.example.Student_Library_Manegement.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookRequestdto {
    private String title;
    private int pages;
    private Genre genre;
    private int quantity;
    private int cardId;
    private int authorId;
}
