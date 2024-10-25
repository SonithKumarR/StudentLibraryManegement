package com.example.Student_Library_Manegement.Controller;

import com.example.Student_Library_Manegement.Model.Author;
import com.example.Student_Library_Manegement.RequestDto.AuthorRequestdto;
import com.example.Student_Library_Manegement.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/save")
    public String saveAuthor(@RequestBody  AuthorRequestdto authorRequestdto){
        String response = authorService.saveAuthor(authorRequestdto);
        return response;
    }
}
