package com.example.Student_Library_Manegement.Model;

import com.example.Student_Library_Manegement.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="created_on")
    @CreationTimestamp
    private Date createdOn;
    @Column(name="updated_on")
    @UpdateTimestamp
    private Date updatedOn;
    @Column(name="card_status")
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    @Column(name="purcBookCnt")
    private int purchaseBookCount;

   @JsonBackReference
    @OneToOne
    @JoinColumn
    private Student student;

    @JsonManagedReference
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksAssignedToCard = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionsForCard = new ArrayList<>();
}
