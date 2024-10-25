package com.example.Student_Library_Manegement.Repository;

import com.example.Student_Library_Manegement.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
