package com.example.Student_Library_Manegement.Converter;

import com.example.Student_Library_Manegement.Model.Student;
import com.example.Student_Library_Manegement.RequestDto.StudentRequestdto;

public class StudentConverter {
    public static Student convertStudentdtoToStdModel(StudentRequestdto studentRequestdto){
        Student student = Student.builder().name(studentRequestdto.getName()).age(studentRequestdto.getAge()).email(studentRequestdto.getEmail()).mobile(studentRequestdto.getMobile()).gender(studentRequestdto.getGender()).build();
        return student;
    }
}
