package com.example.Student_Library_Manegement.RequestDto;

import com.example.Student_Library_Manegement.enums.TransactionName;
import com.example.Student_Library_Manegement.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class TransactionRequestdto {
    private TransactionName transaction_name;
    private TransactionStatus transaction_status;
    private int cardId;
    private int bookId;
}
