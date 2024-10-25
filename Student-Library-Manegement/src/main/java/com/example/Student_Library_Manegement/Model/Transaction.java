package com.example.Student_Library_Manegement.Model;

import com.example.Student_Library_Manegement.enums.PurcBookStore;
import com.example.Student_Library_Manegement.enums.TransactionName;
import com.example.Student_Library_Manegement.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fine")
    private double fine;
    @Column(name="transaction_date")
    @CreationTimestamp
    private LocalDate transactionDate;
    @Column(name="transaction_name")
    @Enumerated(value = EnumType.STRING)
    private TransactionName transactionName;
    @Column(name="due_date")
    private  LocalDate dueDate;
    @Column(name="transaction_status")
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

   @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Book book;
}
