package com.example.Student_Library_Manegement.Converter;

import com.example.Student_Library_Manegement.Model.Transaction;
import com.example.Student_Library_Manegement.RequestDto.TransactionRequestdto;

public class TransactionConverter {
    public static Transaction convertTransdtoToTransModel(TransactionRequestdto transactionRequestdto){
        Transaction transaction = Transaction.builder().transactionStatus(transactionRequestdto.getTransaction_status()).transactionName(transactionRequestdto.getTransaction_name()).build();
        return transaction;
    }
}
