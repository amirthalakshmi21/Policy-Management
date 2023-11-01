package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.entity.AccountCreator;

public interface AccountCreatorRespository extends JpaRepository<AccountCreator, Long> {
}


