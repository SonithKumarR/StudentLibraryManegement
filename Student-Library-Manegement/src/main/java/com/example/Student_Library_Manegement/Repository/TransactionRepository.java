package com.example.Student_Library_Manegement.Repository;

import com.example.Student_Library_Manegement.Model.Author;
import com.example.Student_Library_Manegement.Model.Transaction;
import jakarta.persistence.PostUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(nativeQuery = true,value = "update transaction set transaction_name=:trans_name,fine=:fine where id=:id")
    public String updateTrans(double fine,String trans_name,int id);
    @Query(nativeQuery = true,value = "update transaction set card_id=:crdid,book_id=:bkid where id=:id")
    public String updateCrdbkId(int crdid,int bkid,int id);
    @Query(nativeQuery = true,value = "select * from transaction where book_id=:bookid and card_id=:cardid")
    public Transaction findByusingBookId(int bookid,int cardid);
    @Query(nativeQuery = true,value = "select * from transaction where book_id=:bookid")
    public List<Transaction> getAllTransListByBookid(int bookid);
}

