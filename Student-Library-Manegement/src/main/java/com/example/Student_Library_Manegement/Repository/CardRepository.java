package com.example.Student_Library_Manegement.Repository;

import com.example.Student_Library_Manegement.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
