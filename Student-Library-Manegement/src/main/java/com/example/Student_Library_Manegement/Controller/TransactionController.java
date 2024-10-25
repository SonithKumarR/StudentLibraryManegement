package com.example.Student_Library_Manegement.Controller;

import com.example.Student_Library_Manegement.RequestDto.TransactionRequestdto;
import com.example.Student_Library_Manegement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestdto transactionRequestdto){
        String response = transactionService.saveTransaction(transactionRequestdto);
        return response;
    }
    @PutMapping("/update")
    public String updatecardBkId(@RequestParam("cardid") int cardid,@RequestParam("bookid") int bookid){
        String response = transactionService.updatecardBkId(cardid,bookid);
        return response;
    }

}
