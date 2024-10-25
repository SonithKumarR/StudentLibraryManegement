package com.example.Student_Library_Manegement.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="mobile")
    private  String mobile;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;

    @JsonManagedReference
    @OneToOne(mappedBy="student",cascade = CascadeType.ALL)
    private Card card;
}
