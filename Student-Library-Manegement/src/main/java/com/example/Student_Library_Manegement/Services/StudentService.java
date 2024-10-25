package com.example.Student_Library_Manegement.Services;

import com.example.Student_Library_Manegement.Converter.StudentConverter;
import com.example.Student_Library_Manegement.Model.Card;
import com.example.Student_Library_Manegement.Model.Student;
import com.example.Student_Library_Manegement.Repository.StudentRepository;
import com.example.Student_Library_Manegement.RequestDto.StudentRequestdto;
import com.example.Student_Library_Manegement.enums.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String saveStudent(StudentRequestdto studentRequestdto){
        Student student = StudentConverter.convertStudentdtoToStdModel(studentRequestdto);
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);
        card.setPurchaseBookCount(0);
        student.setCard(card);
        studentRepository.save(student);
        return "Student saved Success.......";
    }
    public String deleteStdById(int id){
        studentRepository.deleteById(id);
        return "student is Deleted....";
    }
}
