package com.example.Student_Library_Manegement.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentRequestdto {
    private String name;
    private String email;
    private  String mobile;
    private int age;
    private String gender;
}
