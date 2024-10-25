package com.example.Student_Library_Manegement.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestdto {
    private String name;
    private String country;
    private int age;
    private double rating;
}
