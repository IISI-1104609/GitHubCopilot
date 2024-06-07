package com.iisi.copilet.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.iisi.copilet.demo.entity.Account;
import com.iisi.copilet.demo.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;
   
    /**
        * 取得所有帳戶資訊。
        *
        * @return 包含所有帳戶資訊的 ResponseEntity 物件。
        */
    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    
    /**
        * 根據名稱獲取帳戶資訊。
        * 
        * @param name 帳戶名稱
        * @return ResponseEntity 包含帳戶資訊的回應實體
        */
    @GetMapping("/account/name")
    public ResponseEntity<Account> getAccountByName(@RequestParam String name) {
        Optional<Account> optionalAccount = accountService.getAccountByName(name);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
        * 創建帳戶。
        * 
        * @param account 要創建的帳戶
        * @return 創建成功的帳戶
        */
    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

}


