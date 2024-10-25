package com.example.Student_Library_Manegement.Services;

import com.example.Student_Library_Manegement.Converter.AuthorConverter;
import com.example.Student_Library_Manegement.Model.Author;
import com.example.Student_Library_Manegement.Repository.AuthorRepository;
import com.example.Student_Library_Manegement.RequestDto.AuthorRequestdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String saveAuthor(@RequestBody AuthorRequestdto authorRequestdto){
        Author author = AuthorConverter.ConvertAuthordtoToAuthorModel(authorRequestdto);
        authorRepository.save(author);
        return "Author saved Success....";
    }
}
