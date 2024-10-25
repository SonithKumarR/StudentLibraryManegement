package com.example.Student_Library_Manegement.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Author")
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;
    @Column(name="rating")
    private double rating;
    @Column(name="age")
    private int age;

    @JsonManagedReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksWrittenByAuthor = new ArrayList<>();
}
