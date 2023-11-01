package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Policy;

@Repository
public interface PolicyRespository extends JpaRepository<Policy, Integer> {

}
