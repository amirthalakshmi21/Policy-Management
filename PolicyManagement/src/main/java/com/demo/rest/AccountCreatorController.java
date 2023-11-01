package com.demo.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.dao.AccountCreatorRespository;
import com.demo.entity.AccountCreator;

@RestController
@RequestMapping("/api/account-creators")
public class AccountCreatorController {
    private final AccountCreatorRespository accountCreatorRepository;

    @Autowired
    public AccountCreatorController(AccountCreatorRespository accountCreatorRepository) {
        this.accountCreatorRepository = accountCreatorRepository;
    }

    @PostMapping
    public AccountCreator createAccountCreator(@RequestBody AccountCreator accountCreator, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input data");
        }
        return accountCreatorRepository.save(accountCreator);
    }
}


