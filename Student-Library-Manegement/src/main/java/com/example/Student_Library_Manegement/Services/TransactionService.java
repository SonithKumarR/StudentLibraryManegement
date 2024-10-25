package com.example.Student_Library_Manegement.Services;

import com.example.Student_Library_Manegement.Converter.TransactionConverter;
import com.example.Student_Library_Manegement.Model.Book;
import com.example.Student_Library_Manegement.Model.Card;
import com.example.Student_Library_Manegement.Model.Transaction;
import com.example.Student_Library_Manegement.Repository.BookRepository;
import com.example.Student_Library_Manegement.Repository.CardRepository;
import com.example.Student_Library_Manegement.Repository.TransactionRepository;
import com.example.Student_Library_Manegement.RequestDto.TransactionRequestdto;
import com.example.Student_Library_Manegement.enums.PurcBookStore;
import com.example.Student_Library_Manegement.enums.TransactionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private BookRepository bookRepository;
    public String saveTransaction(TransactionRequestdto transactionRequestdto){
        Transaction transaction = TransactionConverter.convertTransdtoToTransModel(transactionRequestdto);
        Card card = cardRepository.findById(transactionRequestdto.getCardId()).get();
        int d=card.getStudent().getId();
        Optional<Book> bookOptional = bookRepository.findById(transactionRequestdto.getBookId());
        Book book=bookOptional.get();
        transaction.setBook(book);
        transaction.setCard(card);
        LocalDate currentDate = LocalDate.now();
        if(transactionRequestdto.getTransaction_name().equals(TransactionName.RETURN))
        {
            //update bookstoreto NotAllocated and reduce BookCount by 1.
            //set Transaction_name to return
            // calculate fine and set it.
            // then update the Transaction Record.
            Transaction transaction1=transactionRepository.findByusingBookId(transactionRequestdto.getBookId(),transactionRequestdto.getCardId());
            LocalDate duedate = transaction1.getDueDate();
            long daysDiffrence = ChronoUnit.DAYS.between(currentDate,duedate);
            double fine=0.0;
            if(duedate.isBefore(currentDate)){
                //then add fine amount.
                //charging 3 rupee per 1day.
                fine =(double) daysDiffrence*3.0*-1;
            }
            else {
                // No Fine_Amount will be there
                fine=0.0;
            }
            book.setAllocatedbookquantity(book.getAllocatedbookquantity()-1);
            book.setBookStore(PurcBookStore.NOTALLOCATED);
            card.setPurchaseBookCount(card.getPurchaseBookCount()-1);
            //update here
            transaction1.setTransactionName(TransactionName.RETURN);
            transaction1.setFine(fine);
            transactionRepository.save(transaction1);
           // transactionRepository.updateTrans(fine,transaction1.getId());
            return "Transaction Updated Success.....";
        }
        else //TRANSACTION_NAME IS purchase
        {
            //check if book is allocated or Not.
            //elseif check studentCard purcBookCnt <=2 if not
            // else Book is available set book is Allocated and assign Book to Std.
            //set purcBookCnt and add one;
            //set DueDate by adding some extra days.
            //set cardId in Book
            //Finally save Transaction record.

            if(book.getAllocatedbookquantity()>=book.getQuantity()) {
                List<Transaction> transactionList=transactionRepository.getAllTransListByBookid(transactionRequestdto.getBookId());
                //currentDate = currentDate.plusDays(10);
                //LocalDate miniDueDate = transactionList.get(0).getDueDate();
                int year = currentDate.getYear();
                int curMonth=currentDate.getMonthValue();
                int mnth=transactionList.get(0).getDueDate().getMonthValue();
                for(Transaction transaction2:transactionList) {
                    int mnth2=transaction2.getDueDate().getMonthValue();
                    mnth=Math.min(mnth,mnth2);
                }
                int minDay=40;
                for(Transaction transaction2:transactionList) {
                    if(mnth==transaction2.getDueDate().getMonthValue())
                    minDay=Math.min(minDay,transaction2.getDueDate().getDayOfMonth());
                }
               String bookDate=minDay+"/"+mnth+"/"+year;
                if(mnth<curMonth){
                    year++;
                    bookDate=minDay+"/"+mnth+"/"+year;//now return BookDate;
                }
//                int min = transactionList.get(0).getDueDate().getDayOfMonth();
//                for(Transaction transaction2:transactionList) {
//                    int day1=transaction2.getDueDate().getDayOfMonth();
//                    min=Math.min(min,day1);
//                }
//                int month=currentDate.getMonthValue();
//                int year = currentDate.getYear();
//                return ("Book is Not available till this Date "+min+"/"+month+"/"+year);
                return "Book is Not available till this Date "+bookDate;
            }
//             else if(book.getBookStore().equals(PurcBookStore.ALLOCATED)){//Book_NotAvailble
//                return ("Book is Not available till this Date "+transaction1.getDueDate());//(Optional)add getDays() here.<--
             else if (card.getPurchaseBookCount()>=2) {
                return "You have reached Purchasing Book Limit";
            }
             else {
                book.setAllocatedbookquantity(book.getAllocatedbookquantity()+1);
                int daysToAdd = 1;
                book.setBookStore(PurcBookStore.ALLOCATED);  //Book_isAvailable
                book.setCard(card);
               // LocalDate currentDate = LocalDate.now();
                LocalDate duedate = currentDate;
                LocalDate newDueDate = duedate.plusDays(daysToAdd);
                transaction.setDueDate(newDueDate);
                card.setPurchaseBookCount(card.getPurchaseBookCount()+1);
                transactionRepository.save(transaction);
            }
        }
        return "Transaction saved Success.....";
    }
    public String updatecardBkId(int cardid,int bookid){
        transactionRepository.updateCrdbkId(cardid,bookid,cardid-1);
        return "updated Card and Book Id's";
    }
}
