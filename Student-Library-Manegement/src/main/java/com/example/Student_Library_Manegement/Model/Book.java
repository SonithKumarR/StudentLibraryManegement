package com.example.Student_Library_Manegement.Model;

import com.example.Student_Library_Manegement.enums.Genre;
import com.example.Student_Library_Manegement.enums.PurcBookStore;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Book")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="pages")
    private int pages;
    @Column(name="genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Column(name="quantity")
    private int quantity;
    @Enumerated(value = EnumType.STRING)
    @Column(name="bookStore")
    private PurcBookStore bookStore;
    @Column(name="allocatedbkquantity")
    private int allocatedbookquantity;

   @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonBackReference
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionsForBook = new ArrayList<>();

   @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Author author;
}
