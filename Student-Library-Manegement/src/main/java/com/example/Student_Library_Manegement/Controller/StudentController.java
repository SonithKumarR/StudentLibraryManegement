package com.example.Student_Library_Manegement.Controller;

import com.example.Student_Library_Manegement.RequestDto.StudentRequestdto;
import com.example.Student_Library_Manegement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/api")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestdto studentRequestdto){
        String response = studentService.saveStudent(studentRequestdto);
        return response;
    }
    @DeleteMapping("/delete/{stdId}")
    public String deleteStdById(@PathVariable("stdId") int id){
        String response = studentService.deleteStdById(id);
        return  response;
    }
}
