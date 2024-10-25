package com.example.Student_Library_Manegement.Repository;

import com.example.Student_Library_Manegement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
