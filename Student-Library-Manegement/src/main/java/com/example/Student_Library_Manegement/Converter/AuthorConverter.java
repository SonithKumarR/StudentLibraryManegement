package com.example.Student_Library_Manegement.Converter;

import com.example.Student_Library_Manegement.Model.Author;
import com.example.Student_Library_Manegement.RequestDto.AuthorRequestdto;

public class AuthorConverter {
    public static Author ConvertAuthordtoToAuthorModel(AuthorRequestdto authorRequestdto){
        Author author = Author.builder().age(authorRequestdto.getAge()).name(authorRequestdto.getName()).rating(authorRequestdto.getRating()).country(authorRequestdto.getCountry()).build();
        return author;
    }
}
